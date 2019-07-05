package model.repository;

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
		return result;
	}
}












