package model.repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import mybatis.config.MybatisConfigManager;
import product.domain.Product;

//jdbc가 아닌 웹어플리케이션의 mybatis를 활용하기 위한 DAO 
public class ProductWebDAO {
	MybatisConfigManager configManager=MybatisConfigManager.getInstance();
	
	public int insert(Product product) {
		int result=0;
		SqlSession sqlSession=configManager.getSqlSession();
		result=sqlSession.insert("Product.insert", product);
		sqlSession.commit();
		configManager.freeSession(sqlSession);
		return result;
	}
	
	//모든 레코드 가져오기
	public List selectAll() {
		List list=null;
		SqlSession sqlSession=configManager.getSqlSession();
		list=sqlSession.selectList("Product.selectAll");//XML
		configManager.freeSession(sqlSession);
		return list;
	}
	public List selectAllBySubCategory(int subcategory_id) {
		List list=null;
		SqlSession sqlSession=configManager.getSqlSession();
		list=sqlSession.selectList("Product.selectAllBySubCategory", subcategory_id);//XML
		configManager.freeSession(sqlSession);
		return list;
	}
	
}












