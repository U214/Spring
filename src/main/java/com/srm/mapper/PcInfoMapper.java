package com.srm.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;

import com.srm.domain.PcInfoVO;
import com.srm.domain.UserVO;

@Mapper
public interface PcInfoMapper {
	@ResultMap("PcInfo.pcInfoAddDataFL")
	@Select("SELECT " + 
			"info.PC_CD, " + 
			"info.PC_NM, " + 
			"info.ADDR_MAC, " + 
			"info.ADDR_IP, " + 
			"info.EMAIL, " + 
			"detail.DATACHK_FL " + 
			"FROM " + 
			"PC_INFO_TB info " + 
			"LEFT JOIN " + 
			"PC_DETAIL_TB detail " + 
			"ON " + 
			"info.PC_CD = detail.PC_CD " + 
			"WHERE " + 
			"info.EMAIL = #{email}")
	List getPcInfo(UserVO user);
	
	@Insert("INSERT INTO PC_INFO_TB(PC_CD, PC_NM, ADDR_MAC, ADDR_IP, EMAIL)"
			+ " VALUES(#{pcCode}, #{pcName}, #{macAddress}, #{ipAddress}, #{email})")
	void insertPcInfo(PcInfoVO pcInfo);
}
