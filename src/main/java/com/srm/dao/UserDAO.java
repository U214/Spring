package com.srm.dao;

import org.springframework.stereotype.Repository;

import com.srm.domain.UserVO;
import com.srm.mapper.UserMapper;

@Repository("UserDAO")
public class UserDAO {
	private final UserMapper userMapper;
	
	public UserDAO(UserMapper userMapper)
	{
		this.userMapper = userMapper;
	}
	
	public void insertUser(UserVO vo)
	{
		//mybatis.insert("UserDAO.insertUser", vo);
	}
	
	public void updateUser(UserVO vo)
	{
		//mybatis.update("UserDAO.updateUser", vo);
	}
	
	public void deleteUser(UserVO vo)
	{
		//mybatis.delete("UserDAO.deleteUser", vo);
	}
	
	public UserVO getUser(UserVO vo)
	{
		return userMapper.getUser(vo.getId());
	}
}
