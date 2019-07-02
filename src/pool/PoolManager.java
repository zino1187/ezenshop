package pool;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

//����ݿ��� ��û���� Ŀ�ؼ��� �����ϰ�, �����, ������ ����
//������ �����ϱ� ���� Ŀ�ؼ� Ǯ�� ��ü ����~
public class PoolManager {
	private static PoolManager instance;
	InitialContext context; //java Naming directory interface �� �˻� ��ü
	//�ڿ��� Ŭ�����ȿ� ���� �ʰ� �ܺ��� �������Ϸ� ������ ������������ ����
	//�� �ִ� ����� ����Ŵ.. ( MS : ��Ƽ�� ���丮 ����� ���)
	DataSource ds;
	
	private PoolManager() {
		try {
			context = new InitialContext();
			ds=(DataSource)context.lookup("java:com/env/jdbc/myoracle");
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}
	
	public static PoolManager getInstance() {
		if(instance == null) {
			instance = new PoolManager();
		}
		return instance;
	}
	
	//ds�κ��� Ŀ�ؼ� �ϳ� �뿩�ϱ�!~!
	public Connection getConnection() {
		Connection con=null;
		try {
			con=ds.getConnection(); //Ǯ�� ���� Ŀ�ؼ� �Ѱ� ��ȯ!!
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return con;
	}
	
	//Ǯ�� ���������� ( ��ȯ ) 
	public void freeConnection(Connection con) { //���Ӹ�
		if(con!=null) {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	public void freeConnection(Connection con, PreparedStatement pstmt) {//DML
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
	public void freeConnection(Connection con, PreparedStatement pstmt,ResultSet rs) {//select
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









