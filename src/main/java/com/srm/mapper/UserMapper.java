package com.srm.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.srm.domain.UserVO;

@Mapper
public interface UserMapper {
	@Select("SELECT * FROM USER_INFO_TB WHERE ID = #{id}")
	UserVO getUser(@Param("id") String id);
}
