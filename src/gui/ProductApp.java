package gui;
import java.awt.BorderLayout;
import java.awt.Choice;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
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
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import model.repository.ProductDAO;
import product.domain.Product;
import util.FileManager;
public class ProductApp extends JFrame{
	String url="jdbc:oracle:thin:@localhost:1521:XE";
	String user="java0620";
	String password="java0620";
	Connection con;
	
	
	JPanel p_west;//���� ����
	JPanel p_center;//��� ����
	JPanel p_search; //��� ������ �˻� �г� ( p_center�� ���ʿ�)
	JPanel p_east;//���� ����
	
	//���ʿ����� ��ǰ��..
	MyChoice ch_top;//�ֻ��� ī�װ�
	MyChoice ch_sub;//���� ī�װ�
	JTextField t_name;//��ǰ��
	JTextField t_brand;//�귣���
	JTextField t_price;//���� 
	JTextField t_color;//���� ����
	JTextField t_psize;//������ ����
	JTextField t_filename;//���������� �����ϰԲ�..ó���ҿ���
	JTextArea area;//�� ����	
	JScrollPane scroll;
	JButton bt_regist;//��Ϲ�ư
	JButton bt_find;//����ã�� ��ư
	JFileChooser chooser=new JFileChooser();
	File file;//������ ����� ��������
	
	//������ ������ �����͸� �����ֱ� ���� ���� ������Ʈ
	JTable table;
	JScrollPane tbScroll;
	
	Choice search_type;
	JTextField t_keyword;
	JButton bt_search;
	
	//���ʿ��� 
	JTextField t_name2;//��ǰ��
	JTextField t_brand2;//�귣���
	JTextField t_price2;//���� 
	JTextField t_color2;//���� ����
	JTextField t_psize2;//������ ����
	JTextField t_filename2;//���������� �����ϰԲ�..ó���ҿ���
	JTextArea area2;//�� ����	
	JScrollPane scroll2;
	JButton bt_edit;//������ư
	JButton bt_del;//������ư
	JButton bt_find2;//����ã�� ��ư
	
	ProductDAO productDAO=new ProductDAO();
	//������ ������ ��ǰ�� primary key 
	String product_id;
	MyTableModel model;
	
	public ProductApp() {
		p_west = new JPanel();
		p_center = new JPanel();
		p_search = new JPanel();
		p_east = new JPanel();
		
		ch_top = new MyChoice();
		ch_sub = new MyChoice();
		
		t_name = new JTextField("û����",10);
		t_brand = new JTextField("�����ٿ�",10);
		t_price = new JTextField("0",10);
		
		t_color = new JTextField("red,blue,green",10);
		t_psize = new JTextField("90,95,100,105",10);
		
		t_filename = new JTextField(10);
		area = new JTextArea();
		scroll = new JScrollPane(area);
		bt_regist = new JButton("���");
		bt_find = new JButton("����ã��");
		
		table = new JTable(model=new MyTableModel());
		tbScroll = new JScrollPane(table);
		
		search_type = new Choice();
		search_type.add("��ǰ");
		search_type.add("�귣��");
		search_type.add("����");
		t_keyword = new JTextField(30);
		bt_search = new JButton("�˻�");
		
		t_name2 = new JTextField(10);
		t_brand2 = new JTextField(10);
		t_price2 = new JTextField(10);
		
		t_color2 = new JTextField(10);
		t_psize2 = new JTextField(10);
		
		t_filename2 = new JTextField(10);
		area2 = new JTextArea();
		scroll2 = new JScrollPane(area2);
		bt_edit = new JButton("����");
		bt_del = new JButton("����");
		bt_find2 = new JButton("����ã��");
		
		
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
		p_center.setLayout(new BorderLayout());
		p_center.add(tbScroll);
		
		p_search.add(search_type);
		p_search.add(t_keyword);
		p_search.add(bt_search);
		
		
		p_east.add(t_name2);
		p_east.add(t_brand2);
		p_east.add(t_price2);
		p_east.add(t_color2);
		p_east.add(t_psize2);	
		p_east.add(scroll2);
		p_east.add(t_filename2);
		p_east.add(bt_find2);
		p_east.add(bt_edit);		
		p_east.add(bt_del);		
		/*-----------------------------------------------------
		 ������ �� ��Ÿ�� ó��
		 -----------------------------------------------------*/
		p_west.setPreferredSize(new Dimension(150,700));
		
		ch_top.setPreferredSize(new Dimension(145,35));
		ch_sub.setPreferredSize(new Dimension(145,35));
		scroll.setPreferredSize(new Dimension(140,200));
		scroll2.setPreferredSize(new Dimension(140,200));
		
		t_filename.setEditable(false);
		t_filename2.setEditable(false);
		
		p_center.setBackground(Color.PINK);
		p_east.setBackground(Color.GREEN);
		p_east.setPreferredSize(new Dimension(150,700));
		
		p_center.add(p_search, BorderLayout.NORTH);
		add(p_west, BorderLayout.WEST);
		add(p_center);//BorderLayout.CENTER
		add(p_east, BorderLayout.EAST); //������ ���̾ƿ� ����!!
		
		connect();
		
		//�ʱ⿡ ä������ �۾�!!!
		init();
		
		this.addWindowListener(new WindowAdapter() {
			//������â�� ������,, �ϰ���� �۾�..
			public void windowClosing(WindowEvent e) {
				if(con !=null) { //������ ������ ��츸..�������ִ�..
					try {
						con.close();
						System.exit(0);
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
				}
			}
		});
		
		//���� ī�װ� ���� �̺�Ʈ ���� 
		ch_top.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				int index=ch_top.getSelectedIndex();
				System.out.println("���� ������ ������ ����"+index);
				
				if(index >0) { //��ȿ�� �������� ������ ��츸...
					System.out.println("������ ī�װ��� id�� "+ch_top.id.get(index-1));
					getSubList(ch_top.id.get(index-1));
				}
			}
		});
		
		//����ã�� �̺�Ʈ ���� 
		bt_find.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				findFile();
			}
		});
		//��Ϲ�ư �̺�Ʈ ����
		bt_regist.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean flag = saveFile();
				if(flag) {
					regist();
				}
			}
		});
		
		//���̺� ���콺 ������ �����ϱ�!!!
		table.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				//System.out.println("���콺 Ŭ���޾�?");
				int row=table.getSelectedRow();
				int col=table.getSelectedColumn();
				//System.out.println("row="+row+", col="+col);
				
				product_id=(String)table.getValueAt(row , 0);//������ ��ǥ�� ���� ��ȯ
				System.out.println(product_id);
				
				Product product=productDAO.select(Integer.parseInt(product_id));
				getContent(product);
			}
		});
		
		//���� �̺�Ʈ ����
		bt_del.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				deleteProduct();
			}
		});
		
		setSize(1400,700);
		setVisible(true);
		this.setLocationRelativeTo(null);//������ ����� �����.. 
		
	}
	
	//�����ͺ��̽� ���� 
	public void connect() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con=DriverManager.getConnection(url, user, password);
			if(con == null) {
				this.setTitle("���ӽ���");
			}else {
				this.setTitle("���Ӽ���");
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
			ch_top.add("�����з� ����");
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
	
	//����ī�װ� ��� 
	public void getSubList(int topcategory_id) {
		String sql="select * from subcategory where topcategory_id=?";
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		try {
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, topcategory_id);
			rs=pstmt.executeQuery();
			
			ch_sub.removeAll();//���� ������ ����~~~
			
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
		//ok ��ư�� �������...
		if(result==JFileChooser.APPROVE_OPTION ) {
			file=chooser.getSelectedFile();
		}
	}
	
	//���� ����
	public boolean saveFile() {
		boolean flag=false;
		FileInputStream fis=null;
		FileOutputStream fos=null;
		
		if(file != null) {//������ ������ ������ �ִ� ��츸..
			//���ϸ� �����!! ���糯¥.��������Ȯ����(jpg)
			String name=Long.toString(System.currentTimeMillis());
			String ext=FileManager.getExt(file.getName());
			System.out.println(name+"."+ext);
			
			try {
				fis = new FileInputStream(file);
				fos=new FileOutputStream("D:/final_workspace/Shopping/WebContent/data/"+name+"."+ext);
				
				//�а� �����~~~
				int data=-1;
				byte[]  buff = new byte[1024]; 
				while(true) {
					data=fis.read(buff);//�б�
					if(data==-1)break;//�����Ͱ� ���ٸ� �ݺ��� ����!
					fos.write(buff);//����
				}
				//JOptionPane.showMessageDialog(this,"���� ���� �Ϸ�");
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
			JOptionPane.showMessageDialog(this,"��ǰ�� ������ �������ּ���!!");
			flag=false;
		}
		return flag;
	}	
	
	public void regist() {
		PreparedStatement pstmt=null;
		
		//������ �Է��� �����͸� �̿��Ͽ� insert !!! 
		int index=ch_sub.getSelectedIndex();
		int subcategory_id=ch_sub.id.get(index);
		System.out.println("���� ī�װ��� id"+subcategory_id);
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
				JOptionPane.showMessageDialog(this,"��Ͻ���");
			}else {
				JOptionPane.showMessageDialog(this,"��ϼ���");
				model.initData();
				table.updateUI();
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
	
	//������ ��ǰ�� ������ ����ϱ�!!!
	public void getContent(Product product) {
		t_name2.setText(product.getProduct_name());
		t_brand2.setText(product.getBrand());
		t_price2.setText(Integer.toString(product.getPrice()));
		t_color2.setText(product.getColor());
		t_psize2.setText(product.getPsize());
		area2.setText(product.getContent());
		t_filename2.setText(product.getFilename());		
	}
	
	public void deleteProduct() {
		int result=JOptionPane.showConfirmDialog(this, "�����Ͻðھ��?");
		if(result == JOptionPane.OK_OPTION) {
			//db + ���ϻ���
			if(productDAO.delete(Integer.parseInt(product_id)) !=0) {
				//���ϻ���
				File file=new File("D:/final_workspace/Shopping/WebContent/data/"+t_filename2.getText());
				if(file.exists()) {
					if(!file.delete()) {
						System.out.println("���ϻ����� ����");	
					}else {
						System.out.println("���ϻ����� ����");
					}
				}else {
					System.out.println("������ �������� ����");
				}				
				JOptionPane.showMessageDialog(this, "���� ����");
				model.initData();
				table.updateUI();//���� ������Ʈ ���ΰ�ħ!!
			}
		}
	}
	
	public static void main(String[] args) {
		new ProductApp();
	}
}







