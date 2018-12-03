package com.srm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.srm.domain.PcInfoVO;
import com.srm.domain.UserVO;
import com.srm.mapper.PcInfoMapper;

@Service
@Transactional
public class PcInfoServiceImpl {

	@Autowired
	private PcInfoMapper pcInfoMapper;

	public List getPcInfo(UserVO user) 
	{
		return pcInfoMapper.getPcInfo(user);
	}

}
