package model.repository;

import org.apache.ibatis.session.SqlSession;

import mybatis.config.MybatisConfigManager;
import product.domain.OrderList;

public class OrderListDAO {
	MybatisConfigManager configManager = MybatisConfigManager.getInstance();
	
	//µî·Ï 
	public int insert(OrderList orderList) {
		SqlSession sqlSession = configManager.getSqlSession();
		sqlSession.insert("OrderList.insert", orderList);
		sqlSession.commit();
		configManager.freeSession(sqlSession);
		return orderList.getOrderlist_id();
	}
}




