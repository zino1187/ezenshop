package pool;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.commons.dbcp2.BasicDataSource;

/*������ ���̽� ������ ���� ��ü ���, ��ȯ �۾��� ���⼭ ����ȭ*/
public class DBCPManager {
	private static DBCPManager instance;
	private BasicDataSource ds;
	
	private DBCPManager() {
		ds = new BasicDataSource(); //pool ���� 
		ds.setUrl("jdbc:oracle:thin:@localhost:1521:XE");
		ds.setUsername("java0620");
		ds.setPassword("java0620");
		ds.setMaxIdle(10);
		ds.setMaxIdle(5);
		ds.setMaxOpenPreparedStatements(100);		
	}
	
	public static DBCPManager getInstance() {
		if(instance == null) {
			instance = new DBCPManager();
		}
		return instance;
	}
	
	//Ŀ�ؼ� ���!!!
	public Connection getConnection() {
		Connection con=null;
		try {
			con = ds.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return con;
	}
	
	//Ŀ�ؼ� �ݳ� 
	public void freeConnection(Connection con) {
		if(con!=null) {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	public void freeConnection(Connection con, PreparedStatement pstmt) {
		if(pstmt!=null) {
			try {
				pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if(con!=null) {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
	}
	public void freeConnection(Connection con, PreparedStatement pstmt, ResultSet rs) {
		if(rs!=null) {
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if(pstmt!=null) {
			try {
				pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if(con!=null) {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
	}
	
}












