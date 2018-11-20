package com.srm.service;

import com.srm.domain.UserVO;

public interface UserService {
	void join(UserVO vo);
	void withdraw(UserVO vo);
	void login(UserVO vo);
	void logout(UserVO vo);
	void updateUserInfo(UserVO vo);
}
