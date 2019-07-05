package gui;
import java.util.List;

import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.AbstractTableModel;

import model.repository.ProductDAO;
import product.domain.Product;

/* �� ���̺� �� ��ü�κ��� ������ ���� ��ü�� JTable �̴�!!!
 * �� ���̴�!!
 * */
//TableModel �������̽��� �����ص� ������, �� �ʿ��� �޼��常�� �������ϰ�
//���� ��쿣 AbstractTableModel �� �̿��ϸ� �ȴ�...
//�� TableModel �������̽��� AbstractTableModel Ŭ������ �̹� �����س���
//���̴�..��ġ �����ʸ� �����ϴ� �����ó��...
public class MyTableModel extends AbstractTableModel{
	//�����Ϳ� �÷� 
	String[][] data;
	
	String[] column= {
		"PRODUCT_ID",
		"SUBCATEGORY_ID",
		"�����з� ��",
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
	
	//�������迭 ���� �����, 1ȸ���� ���뼺�� ����!!.
	//���� �޼���� �����س��ƾ� �Ѵ�!!
	public void initData() {
		productList=productDAO.selectAll();
		
		//�÷����� �迭�� ��ȯ!!!
		Object[] array=(Object[])productList.toArray();
		data = new String[array.length][column.length]; //�������� �迭 ����
		
		for(int i=0;i<array.length;i++) {
			
			Product product=(Product)array[i]; //������ ��ü�� Ŭ������ ǥ��
			String[] record = new String[column.length];//������ ��ü�� �迭�� ǥ��
			
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
			
			data[i]=record;//������ 2���� �迭 �� ��ҿ� ��� ������ �������迭�� �־���
		}
		
	}
	
	//���� ���� row
	public int getRowCount() {
		return productList.size();
	}

	//���� ���� column
	public int getColumnCount() {
		return column.length;
	}
	
	@Override
	public String getColumnName(int col) {
		return column[col];
	}
	
	// ������ ��,���� �� ���� �����ϴ� �޼���
	public Object getValueAt(int row, int col) {
		//System.out.println("getValueAt("+row+", "+col+")");
		return data[row][col];
	}



}











