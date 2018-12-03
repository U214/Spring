package com.srm.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.srm.domain.UserVO;

@Mapper
public interface UserMapper {
	@Select("SELECT * FROM USER_INFO_TB WHERE EMAIL = #{email}")
	UserVO getUser(UserVO user);
	
	@Insert("INSERT INTO USER_INFO_TB(EMAIL, PASSWORD, NAME) VALUES(#{email}, #{password}, #{name})")
	void insertUser(UserVO user);
}
