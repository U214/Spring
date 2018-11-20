package com.srm.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.srm.domain.PcInfoVO;
import com.srm.domain.PcNetworkVO;
import com.srm.util.SqlSessionFactoryBean;

public class PcNetworkDAO {
	private SqlSession mybatis;
	
	public PcNetworkDAO()
	{
		mybatis = SqlSessionFactoryBean.getSqlSessionInstance();
	}
	
	public void insertPcNetwork(PcNetworkVO vo)
	{
		mybatis.insert("PcNetworkDAO.insertPcNetwork", vo);
	}
	
	public void updatePcNetwork(PcNetworkVO vo)
	{
		mybatis.update("PcNetworkDAO.updatePcNetwork", vo);
	}
	
	public void deletePcNetwork(PcInfoVO vo)
	{
		mybatis.delete("PcNetworkDAO.deletePcNetwork", vo);
	}
	
	public PcNetworkVO getPcNetwork(PcNetworkVO vo)
	{
		return (PcNetworkVO) mybatis.selectOne("PcNetworkDAO.getPcNetwork", vo);
	}
	
	public List<PcNetworkVO> getPcNetworkList(PcNetworkVO vo)
	{
		return mybatis.selectList("PcNetworkDAO.getPcNetworkList", vo);
	}
}
