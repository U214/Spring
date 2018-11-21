package com.srm.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.srm.domain.PcInfoVO;
import com.srm.domain.UserVO;

@Repository("PcInfoDAO")
public class PcInfoDAO {
	private SqlSession mybatis;
	
	public PcInfoDAO()
	{
	}
	
	public void insertPcInfo(PcInfoVO vo)
	{
		mybatis.insert("PcInfoDAO.insertPcInfo", vo);
	}
	
	public void updatePcInfo(PcInfoVO vo)
	{
		mybatis.update("PcInfoDAO.updatePcInfo", vo);
	}
	
	public void deletePcInfo(UserVO vo)
	{
		mybatis.delete("PcInfoDAO.deletePcInfo", vo);
	}
	
	public PcInfoVO getPcInfo(PcInfoVO vo)
	{
		return (PcInfoVO) mybatis.selectOne("PcInfoDAO.getPcInfo", vo);
	}
	
	public List<PcInfoVO> getPcInfoList(UserVO vo)
	{
		return mybatis.selectList("PcInfoDAO.getPcInfoList", vo);
	}
}

