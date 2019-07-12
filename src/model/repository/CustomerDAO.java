package model.repository;

import org.apache.ibatis.session.SqlSession;

import mybatis.config.MybatisConfigManager;
import product.domain.Customer;

public class CustomerDAO {
	MybatisConfigManager configManager = MybatisConfigManager.getInstance();
	
	//µî·Ï 
	public int insert(Customer customer) {
		SqlSession sqlSession = configManager.getSqlSession();
		sqlSession.insert("Customer.insert", customer);
		sqlSession.commit();
		configManager.freeSession(sqlSession);
		return customer.getCustomer_id();
	}
}




