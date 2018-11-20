package com.srm.dao;

import org.apache.ibatis.session.SqlSession;

import com.srm.domain.UserVO;
import com.srm.util.SqlSessionFactoryBean;

public class UserDAO {
	private SqlSession mybatis;
	
	public UserDAO()
	{
		mybatis = SqlSessionFactoryBean.getSqlSessionInstance();
	}
	
	public void insertUser(UserVO vo)
	{
		mybatis.insert("UserDAO.insertUser", vo);
	}
	
	public void updateUser(UserVO vo)
	{
		mybatis.update("UserDAO.updateUser", vo);
	}
	
	public void deleteUser(UserVO vo)
	{
		mybatis.delete("UserDAO.deleteUser", vo);
	}
	
	public UserVO getUser(UserVO vo)
	{
		return (UserVO) mybatis.selectOne("UserDAO.getUser", vo);
	}
}
