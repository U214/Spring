package com.srm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.srm.dao.PcDetailDAO;
import com.srm.dao.PcInfoDAO;
import com.srm.dao.PcNetworkDAO;
import com.srm.dao.PcProcessDAO;
import com.srm.dao.PcRealTimeDAO;
import com.srm.dao.UserDAO;
import com.srm.domain.PcInfoVO;
import com.srm.domain.UserVO;
import com.srm.service.UserService;

@Service("userService")
public class UserServiceImpl {

	@Autowired
	private UserDAO userDAO;
	private PcInfoDAO pcInfoDAO;
	private PcDetailDAO pcDetailDAO;
	private PcRealTimeDAO pcRealTimeDAO;
	private PcNetworkDAO pcNetworkDAO;
	private PcProcessDAO pcProcessDAO;
	
	// 회원 추가
	public void insertUser(UserVO vo) {
		// 중복확인은 js에서 처리
		userDAO.insertUser(vo);
	}

	// 회원 탈퇴
	public void deleteUser(UserVO vo) {
		// 사용자의 PC 목록을 가져온다.
		List<PcInfoVO> pcList = pcInfoDAO.getPcInfoList(vo);
		
		// PC 목록마다 저장된 정보를 삭제한다.
		for (int i = 0; i < pcList.size(); ++i)
		{
			pcDetailDAO.deletePcDetail(pcList.get(i));
			pcRealTimeDAO.deletePcRealTime(pcList.get(i));
			pcNetworkDAO.deletePcNetwork(pcList.get(i));
			pcProcessDAO.deletePcProcess(pcList.get(i));
		}
		
		// PC 목록을 삭제한다.
		pcInfoDAO.deletePcInfo(vo);
		
		// 사용자 정보를 삭제한다.
		userDAO.deleteUser(vo);
	}

	// 로그인 체크
	public void loginCheck(UserVO vo) throws Exception {
		UserVO getUser = userDAO.getUser(vo); 
		
		if (getUser == null ||
			getUser.getPassword() != vo.getPassword())
		{
			throw new Exception("로그인 실패");
		}
	}

	// 회원 정보 업데이트
	public void updateUser(UserVO vo) {
		// TODO Auto-generated method stub

	}
	
	// 회원 정보 가져오기
	public void getUser() {
		
	}

}
