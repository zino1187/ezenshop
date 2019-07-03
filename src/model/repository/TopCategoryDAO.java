package model.repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import mybatis.config.MybatisConfigManager;

//�� Ŭ������ TopCategory ���̺� CRUD�� ����ϴ� ��ü
//�����ͺ��̽��� ���̺��� 1�� �����, �� ���̺� 1:1 �����ϴ� CRUD��ü
//�� ������ �Ѵ�...(������������ �о߿���)
//jdbc, mybatis, jpa, hibernate...
public class TopCategoryDAO {
	MybatisConfigManager configManager=MybatisConfigManager.getInstance();
	
	//ī�װ� 1�� ���
	public void insert() {
	}
	
	//��� ī�װ��������� 
	public List selectAll() {
		SqlSession sqlSession=configManager.getSqlSession();
		List list=sqlSession.selectList("TopCategory.selectAll");
		return list;
	}
}









