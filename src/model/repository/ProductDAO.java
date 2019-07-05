package model.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import pool.DBCPManager;
import product.domain.Product;

//이 DAO는 jdbc를 직접사용하는 기반이다.. 
public class ProductDAO {
	DBCPManager dbcpManager=DBCPManager.getInstance();
	
	//상품 정보를 가져오되( 하위카테고리까지 같이...)
	public List selectAll() {
		Connection con=dbcpManager.getConnection();
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		List list=new ArrayList(); //여러개의 DTO 를 담게될 리스트!!
		
		//String 객체는 immutable 이다!! (불변)
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
}





