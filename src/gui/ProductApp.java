package gui;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import util.FileManager;
public class ProductApp extends JFrame{
	String url="jdbc:oracle:thin:@localhost:1521:XE";
	String user="java0620";
	String password="java0620";
	Connection con;
	
	
	JPanel p_west;//서쪽 영역
	JPanel p_center;//가운데 영역
	JPanel p_search; //가운데 영역의 검색 패널 ( p_center의 북쪽에)
	JPanel p_east;//동쪽 영역
	
	//서쪽영역의 부품들..
	MyChoice ch_top;//최상위 카테고리
	MyChoice ch_sub;//하위 카테고리
	JTextField t_name;//상품명
	JTextField t_brand;//브랜드명
	JTextField t_price;//가격 
	JTextField t_color;//색상 종류
	JTextField t_psize;//사이즈 선택
	JTextField t_filename;//파일추저로 선택하게끔..처리할예정
	JTextArea area;//상세 설명	
	JScrollPane scroll;
	JButton bt_regist;//등록버튼
	JButton bt_find;//파일찾기 버튼
	JFileChooser chooser=new JFileChooser();
	File file;//유저가 등록할 파일정보
	
	public ProductApp() {
		p_west = new JPanel();
		p_center = new JPanel();
		p_search = new JPanel();
		p_east = new JPanel();
		
		ch_top = new MyChoice();
		ch_sub = new MyChoice();
		
		t_name = new JTextField("청바지",10);
		t_brand = new JTextField("지오다오",10);
		t_price = new JTextField("0",10);
		
		t_color = new JTextField("red,blue,green",10);
		t_psize = new JTextField("90,95,100,105",10);
		
		t_filename = new JTextField(10);
		area = new JTextArea();
		scroll = new JScrollPane(area);
		bt_regist = new JButton("등록");
		bt_find = new JButton("파일찾기");
		
		p_west.add(ch_top);
		p_west.add(ch_sub);
		p_west.add(t_name);
		p_west.add(t_brand);
		p_west.add(t_price);
		p_west.add(t_color);
		p_west.add(t_psize);	
		p_west.add(scroll);
		p_west.add(t_filename);
		p_west.add(bt_find);
		p_west.add(bt_regist);
		
		/*-----------------------------------------------------
		 사이즈 등 스타일 처리
		 -----------------------------------------------------*/
		p_west.setPreferredSize(new Dimension(150,700));
		p_west.setBackground(Color.YELLOW);
		ch_top.setPreferredSize(new Dimension(145,35));
		ch_sub.setPreferredSize(new Dimension(145,35));
		scroll.setPreferredSize(new Dimension(140,200));
		t_filename.setEditable(false);

		
		add(p_west, BorderLayout.WEST);
		
		connect();
		
		//초기에 채워넣을 작업!!!
		init();
		
		this.addWindowListener(new WindowAdapter() {
			//윈도우창이 닫힐때,, 하고싶은 작업..
			public void windowClosing(WindowEvent e) {
				if(con !=null) { //접속이 성공된 경우만..닫을수있다..
					try {
						con.close();
						System.exit(0);
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
				}
			}
		});
		
		//상위 카테고리 선택 이벤트 구현 
		ch_top.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				int index=ch_top.getSelectedIndex();
				System.out.println("내가 선택한 아이템 순번"+index);
				
				if(index >0) { //유효한 아이템을 선택한 경우만...
					System.out.println("선택한 카테고리의 id는 "+ch_top.id.get(index-1));
					getSubList(ch_top.id.get(index-1));
				}
			}
		});
		
		//파일찾기 이벤트 구현 
		bt_find.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				findFile();
			}
		});
		//등록버튼 이벤트 구현
		bt_regist.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean flag = saveFile();
				if(flag) {
					regist();
				}
			}
		});
		
		setSize(1000,700);
		setVisible(true);
		this.setLocationRelativeTo(null);//언제나 모니터 정가운데.. 
		
	}
	
	//데이터베이스 접속 
	public void connect() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con=DriverManager.getConnection(url, user, password);
			if(con == null) {
				this.setTitle("접속실패");
			}else {
				this.setTitle("접속성공");
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void init() {
		String sql="select * from topcategory";
		PreparedStatement pstmt = null;
		ResultSet rs=null;
		
		try {
			pstmt=con.prepareStatement(sql);
			rs=pstmt.executeQuery();
			ch_top.add("상위분류 선택");
			while(rs.next()) {
				ch_top.id.add(rs.getInt("topcategory_id"));
				ch_top.add(rs.getString("name"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			if(rs!=null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(pstmt!=null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}			
		}	
	}
	
	//하위카테고리 출력 
	public void getSubList(int topcategory_id) {
		String sql="select * from subcategory where topcategory_id=?";
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		try {
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, topcategory_id);
			rs=pstmt.executeQuery();
			
			ch_sub.removeAll();//기존 아이템 삭제~~~
			
			while(rs.next()) {
				ch_sub.id.add(rs.getInt("subcategory_id"));
				ch_sub.add(rs.getString("name"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			if(rs!=null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(pstmt!=null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}							
		}
	}
	
	public void findFile() {
		int result=chooser.showOpenDialog(this);
		//ok 버튼을 누른경우...
		if(result==JFileChooser.APPROVE_OPTION ) {
			file=chooser.getSelectedFile();
		}
	}
	
	//저장 수행
	public boolean saveFile() {
		boolean flag=false;
		FileInputStream fis=null;
		FileOutputStream fos=null;
		
		if(file != null) {//유저가 선택한 파일이 있는 경우만..
			//파일명 만들기!! 현재날짜.유저선택확장자(jpg)
			String name=Long.toString(System.currentTimeMillis());
			String ext=FileManager.getExt(file.getName());
			System.out.println(name+"."+ext);
			
			try {
				fis = new FileInputStream(file);
				fos=new FileOutputStream("D:/final_workspace/Shopping/WebContent/data/"+name+"."+ext);
				
				//읽고 내뱉고~~~
				int data=-1;
				byte[]  buff = new byte[1024]; 
				while(true) {
					data=fis.read(buff);//읽기
					if(data==-1)break;//데이터가 없다면 반복문 중지!
					fos.write(buff);//쓰기
				}
				//JOptionPane.showMessageDialog(this,"파일 저장 완료");
				t_filename.setText(name+"."+ext);
				flag=true;
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}finally {
				if(fos !=null) {
					try {
						fos.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
				if(fis !=null) {
					try {
						fis.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}			
		}else {
			JOptionPane.showMessageDialog(this,"상품의 사진을 선택해주세요!!");
			flag=false;
		}
		return flag;
	}	
	
	public void regist() {
		PreparedStatement pstmt=null;
		
		//유저가 입력한 데이터를 이용하여 insert !!! 
		int index=ch_sub.getSelectedIndex();
		int subcategory_id=ch_sub.id.get(index);
		System.out.println("하위 카테고리의 id"+subcategory_id);
		String product_name=t_name.getText();
		String brand = t_brand.getText();
		String price = t_price.getText();
		String color = t_color.getText();
		String psize = t_psize.getText();
		String filename=t_filename.getText();
		String content=area.getText();
		
		String sql="insert into product(product_id,subcategory_id,product_name,brand,price,color,psize,filename,content)";
		sql +=" values(seq_product.nextval,?,?,?,?,?,?,?,?)";
		
		try {
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, subcategory_id);
			pstmt.setString(2, product_name);
			pstmt.setString(3, brand);
			pstmt.setString(4, price);
			pstmt.setString(5, color);
			pstmt.setString(6, psize);
			pstmt.setString(7, filename);
			pstmt.setString(8, content);
			
			int result=pstmt.executeUpdate();
			if(result ==0) {
				JOptionPane.showMessageDialog(this,"등록실패");
			}else {
				JOptionPane.showMessageDialog(this,"등록성공");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			if(pstmt!=null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}									
		}
	}
	
	public static void main(String[] args) {
		new ProductApp();
	}
}







