package com.srm.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.srm.domain.PcInfoVO;
import com.srm.domain.PcRealTimeVO;

@Repository("PcRealTimeDAO")
public class PcRealTimeDAO {
	private SqlSession mybatis;
	
	public PcRealTimeDAO()
	{
	}
	
	public void insertPcRealTime(PcRealTimeVO vo)
	{
		mybatis.insert("PcRealTimeDAO.insertPcRealTime", vo);
	}
	
	public void updatePcRealTime(PcRealTimeVO vo)
	{
		mybatis.update("PcRealTimeDAO.updatePcRealTime", vo);
	}
	
	public void deletePcRealTime(PcInfoVO vo)
	{
		mybatis.delete("PcRealTimeDAO.deletePcRealTime", vo);
	}
	
	public PcRealTimeVO getPcRealTime(PcRealTimeVO vo)
	{
		return (PcRealTimeVO) mybatis.selectOne("PcRealTimeDAO.getPcRealTime", vo);
	}
	
	public List<PcRealTimeVO> getPcRealTimeList(PcRealTimeVO vo)
	{
		return mybatis.selectList("PcRealTimeDAO.getPcRealTimeList", vo);
	}
}
