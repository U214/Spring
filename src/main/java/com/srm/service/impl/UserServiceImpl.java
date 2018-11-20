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
	
	// ȸ�� �߰�
	public void insertUser(UserVO vo) {
		// �ߺ�Ȯ���� js���� ó��
		userDAO.insertUser(vo);
	}

	// ȸ�� Ż��
	public void deleteUser(UserVO vo) {
		// ������� PC ����� �����´�.
		List<PcInfoVO> pcList = pcInfoDAO.getPcInfoList(vo);
		
		// PC ��ϸ��� ����� ������ �����Ѵ�.
		for (int i = 0; i < pcList.size(); ++i)
		{
			pcDetailDAO.deletePcDetail(pcList.get(i));
			pcRealTimeDAO.deletePcRealTime(pcList.get(i));
			pcNetworkDAO.deletePcNetwork(pcList.get(i));
			pcProcessDAO.deletePcProcess(pcList.get(i));
		}
		
		// PC ����� �����Ѵ�.
		pcInfoDAO.deletePcInfo(vo);
		
		// ����� ������ �����Ѵ�.
		userDAO.deleteUser(vo);
	}

	// �α��� üũ
	public void loginCheck(UserVO vo) throws Exception {
		UserVO getUser = userDAO.getUser(vo); 
		
		if (getUser == null ||
			getUser.getPassword() != vo.getPassword())
		{
			throw new Exception("�α��� ����");
		}
	}

	// ȸ�� ���� ������Ʈ
	public void updateUser(UserVO vo) {
		// TODO Auto-generated method stub

	}
	
	// ȸ�� ���� ��������
	public void getUser() {
		
	}

}
