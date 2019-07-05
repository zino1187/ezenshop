package model.repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import mybatis.config.MybatisConfigManager;

public class SubCategoryDAO {
	MybatisConfigManager configManager=MybatisConfigManager.getInstance();
	 
	public List selectAll(int topcategory_id) {
		SqlSession sqlSession=configManager.getSqlSession();
		List list=sqlSession.selectList("SubCategory.selectAll",topcategory_id);
		configManager.freeSession(sqlSession);//¹Ý³³!!
		return list;
	}
	
}




