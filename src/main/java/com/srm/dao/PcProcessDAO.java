package com.srm.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.srm.domain.PcInfoVO;
import com.srm.domain.PcProcessVO;
import com.srm.util.SqlSessionFactoryBean;

public class PcProcessDAO {
	private SqlSession mybatis;
	
	public PcProcessDAO()
	{
		mybatis = SqlSessionFactoryBean.getSqlSessionInstance();
	}
	
	public void insertPcProcess(PcProcessVO vo)
	{
		mybatis.insert("PcProcessDAO.insertPcProcess", vo);
	}
	
	public void updatePcProcess(PcProcessVO vo)
	{
		mybatis.update("PcProcessDAO.updatePcProcess", vo);
	}
	
	public void deletePcProcess(PcInfoVO vo)
	{
		mybatis.delete("PcProcessDAO.deletePcProcess", vo);
	}
	
	public PcProcessVO getPcProcess(PcProcessVO vo)
	{
		return (PcProcessVO) mybatis.selectOne("PcProcessDAO.getPcProcess", vo);
	}
	
	public List<PcProcessVO> getPcProcessList(PcProcessVO vo)
	{
		return mybatis.selectList("PcProcessDAO.getPcProcessList", vo);
	}
}
