package model.repository;

import org.apache.ibatis.session.SqlSession;

import mybatis.config.MybatisConfigManager;
import product.domain.OrderDetail;

public class OrderDetailtDAO {
	MybatisConfigManager configManager = MybatisConfigManager.getInstance();
	
	//µî·Ï 
	public int insert(OrderDetail orderDetail) {
		int result=0;
		SqlSession sqlSession = configManager.getSqlSession();
		result=sqlSession.insert("OrderDetail.insert", orderDetail);
		sqlSession.commit();
		configManager.freeSession(sqlSession);
		return result;
	}
}




