package gui;
import java.util.List;

import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.AbstractTableModel;

import model.repository.ProductDAO;
import product.domain.Product;

/* 이 테이블 모델 객체로부터 정보를 얻어가는 주체는 JTable 이다!!!
 * 즉 뷰이다!!
 * */
//TableModel 인터페이스를 구현해도 되지만, 꼭 필요한 메서드만을 재정의하고
//싶을 경우엔 AbstractTableModel 을 이용하면 된다...
//즉 TableModel 인터페이스를 AbstractTableModel 클래스가 이미 구현해놓은
//것이다..마치 리스너를 지원하는 어댑터처럼...
public class MyTableModel extends AbstractTableModel{
	//데이터와 컬럼 
	String[][] data;
	
	String[] column= {
		"PRODUCT_ID",
		"SUBCATEGORY_ID",
		"하위분류 명",
		"PRODUCT_NAME",
		"BRAND",
		"PRICE",
		"COLOR",
		"PSIZE",
		"FILENAME",
		"CONTENT"
	};
	
	ProductDAO productDAO= new ProductDAO();
	List<Product> productList;
	
	public MyTableModel() {
		initData();
	}
	
	//이차원배열 구성 기능은, 1회성이 재사용성이 높다!!.
	//따라서 메서드로 정의해놓아야 한다!!
	public void initData() {
		productList=productDAO.selectAll();
		
		//컬렉션을 배열로 변환!!!
		Object[] array=(Object[])productList.toArray();
		data = new String[array.length][column.length]; //빈이차원 배열 생성
		
		for(int i=0;i<array.length;i++) {
			
			Product product=(Product)array[i]; //현실의 객체를 클래스로 표현
			String[] record = new String[column.length];//현실의 객체를 배열로 표현
			
			record[0] = Integer.toString(product.getProduct_id());
			record[1] = Integer.toString(product.getSubCategory().getSubcategory_id());
			record[2] = product.getSubCategory().getName();
			record[3] = product.getProduct_name();
			record[4] = product.getBrand();
			record[5] = Integer.toString(product.getPrice());
			record[6] = product.getColor();
			record[7] = product.getPsize();
			record[8] = product.getFilename();
			record[9] = product.getContent();
			
			data[i]=record;//기존의 2차원 배열 각 요소에 방금 생성한 일차원배열을 넣어줌
		}
		
	}
	
	//행의 갯수 row
	public int getRowCount() {
		return productList.size();
	}

	//열의 갯수 column
	public int getColumnCount() {
		return column.length;
	}
	
	@Override
	public String getColumnName(int col) {
		return column[col];
	}
	
	// 지정된 행,열에 들어갈 값을 결정하는 메서드
	public Object getValueAt(int row, int col) {
		//System.out.println("getValueAt("+row+", "+col+")");
		return data[row][col];
	}



}











