package mybatis.config;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

/*
 * Mybatis 프레임웍은 개발자가 JDBC 객체를 일일이 제어하여
 * 코드를 작성하는 방식보다는 xml 을 이용하여 쿼리문에 집중할수
 * 있도록 해준다..따라서 mybatis 를 이용할 경우 더이상 Connection,
 * PreparedStatement, ResultSet 과 같은 JDBC API를 직접 제어할
 * 필요가 없다!! 그냥 쿼리문을 위해선 SqlSession 객체만 사용..
 * SqlSesio
 * */
public class MybatisConfigManager {
	private static MybatisConfigManager instance;
	
	InputStream inputStream;
	SqlSessionFactory sqlSessionFactory;
	
	private MybatisConfigManager() {
		String resource = "mybatis/config/mybatis-config.xml";
		try {
			inputStream = Resources.getResourceAsStream(resource);
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static MybatisConfigManager getInstance() {
		if(instance == null) {
			instance = new MybatisConfigManager();
		}
		return instance;
	}

	//mybatis의 쿼리문 수행 객체인 SqlSession 1개를 Factory로부터 반환!!
	public SqlSession getSqlSession() {
		SqlSession sqlSession=null;
		sqlSession=sqlSessionFactory.openSession();
		return sqlSession;
	}
	
	//반환
	public void freeSession(SqlSession sqlSession) {
		sqlSession.close();
	}
}










