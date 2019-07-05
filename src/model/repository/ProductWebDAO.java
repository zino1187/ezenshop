package model.repository;

import org.apache.ibatis.session.SqlSession;

import mybatis.config.MybatisConfigManager;
import product.domain.Product;

//jdbc�� �ƴ� �����ø����̼��� mybatis�� Ȱ���ϱ� ���� DAO 
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












