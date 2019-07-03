package model.repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import mybatis.config.MybatisConfigManager;

//이 클래스는 TopCategory 테이블에 CRUD를 담당하는 객체
//데이터베이스에 테이블을 1개 만들면, 그 테이블에 1:1 대응하는 CRUD객체
//를 만들어야 한다...(엔터프라이즈 분야에서)
//jdbc, mybatis, jpa, hibernate...
public class TopCategoryDAO {
	MybatisConfigManager configManager=MybatisConfigManager.getInstance();
	
	//카테고리 1건 등록
	public void insert() {
	}
	
	//모든 카테고리가져오기 
	public List selectAll() {
		SqlSession sqlSession=configManager.getSqlSession();
		List list=sqlSession.selectList("TopCategory.selectAll");
		return list;
	}
}









