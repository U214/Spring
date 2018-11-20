package com.srm.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.srm.domain.PcDetailVO;
import com.srm.domain.PcInfoVO;
import com.srm.util.SqlSessionFactoryBean;

public class PcDetailDAO {
	private SqlSession mybatis;
	
	public PcDetailDAO()
	{
		mybatis = SqlSessionFactoryBean.getSqlSessionInstance();
	}
	
	public void insertPcDetail(PcDetailVO vo)
	{
		mybatis.insert("PcDetailDAO.insertPcDetail", vo);
	}
	
	public void updatePcDetail(PcDetailVO vo)
	{
		mybatis.update("PcDetailDAO.updatePcDetail", vo);
	}
	
	public void deletePcDetail(PcInfoVO vo)
	{
		mybatis.delete("PcDetailDAO.deletePcDetail", vo);
	}
	
	public PcDetailVO getPcDetail(PcDetailVO vo)
	{
		return (PcDetailVO) mybatis.selectOne("PcDetailDAO.getPcDetail", vo);
	}
	
	public List<PcDetailVO> getPcDetailList(PcDetailVO vo)
	{
		return mybatis.selectList("PcDetailDAO.getPcDetailList", vo);
	}
}
