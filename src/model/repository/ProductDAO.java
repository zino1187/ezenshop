package model.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import pool.DBCPManager;
import product.domain.Product;

//�� DAO�� jdbc�� ��������ϴ� ����̴�.. 
public class ProductDAO {
	DBCPManager dbcpManager=DBCPManager.getInstance();
	
	//��ǰ ������ ��������( ����ī�װ����� ����...)
	public List selectAll() {
		Connection con=dbcpManager.getConnection();
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		List list=new ArrayList(); //�������� DTO �� ��Ե� ����Ʈ!!
		
		//String ��ü�� immutable �̴�!! (�Һ�)
		StringBuilder sql=new StringBuilder();
		sql.append("select product_id, product_name, brand, price, color, ");
		sql.append("psize, filename, content,");
		sql.append("s.subcategory_id as subcategory_id, name");
		sql.append(" from subcategory s , product p");
		sql.append(" where s.subcategory_id = p.subcategory_id");
		try {
			pstmt=con.prepareStatement(sql.toString());
			rs=pstmt.executeQuery();
			
			while(rs.next()) {
				Product product = new Product();
				product.getSubCategory().setName(rs.getString("name"));
				product.getSubCategory().setSubcategory_id(rs.getInt("subcategory_id"));
				product.setProduct_id(rs.getInt("product_id"));
				product.setProduct_name(rs.getString("product_name"));
				product.setBrand(rs.getString("brand"));
				product.setPrice(rs.getInt("price"));
				product.setColor(rs.getString("color"));
				product.setPsize(rs.getString("psize"));
				product.setFilename(rs.getString("filename"));
				product.setContent(rs.getString("content"));
				
				list.add(product);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			dbcpManager.freeConnection(con, pstmt, rs);
		}
		return list;
	}
	
	//�Խù� �Ѱ� ��������!!
	public Product select(int product_id) {
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		Product product=null;
		String sql="select * from product where product_id=?";
		
		con=dbcpManager.getConnection();//Ǯ�κ��� �뿩
		try {
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, product_id);
			rs=pstmt.executeQuery();
			if(rs.next()) { //1���϶��� ���ǹ�..
				product = new Product();
				product.getSubCategory().setSubcategory_id(rs.getInt("subcategory_id"));
				product.setProduct_id(rs.getInt("product_id"));
				product.setProduct_name(rs.getString("product_name"));
				product.setBrand(rs.getString("brand"));
				product.setPrice(rs.getInt("price"));
				product.setColor(rs.getString("color"));
				product.setPsize(rs.getString("psize"));
				product.setFilename(rs.getString("filename"));
				product.setContent(rs.getString("content"));			
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			dbcpManager.freeConnection(con, pstmt, rs);
		}
		return product;
	}
	
	//�Խù� 1�� ���� DML ( insert, delete, update)
	//�� �������� ���� �ݿ��� ���ڵ� ���� ��ȯ!! 
	//���� insert ������ ������ ��� 1
	public int delete(int product_id) {
		Connection con=null;
		PreparedStatement pstmt=null;
		int result=0;
		String sql="delete from product where product_id=?";
		
		con=dbcpManager.getConnection();
		try {
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, product_id);
			result=pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			dbcpManager.freeConnection(con, pstmt);
		}
		return result;
	}
}



















