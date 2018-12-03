package com.srm.domain;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import lombok.Data;

// 회원 정보 VO
@Data
public class UserVO {
	// 회원 아이디
	@Size(max=25)
	@Pattern(regexp="^[0-9a-zA-Z][0-9a-zA-Z\\_\\-\\.\\+]+[0-9a-zA-Z]@[0-9a-zA-Z][0-9a-zA-Z\\_\\-]*[0-9a-zA-Z](\\.[a-zA-Z]{2,6}){1,2}$") 
	private String email;
	// 회원 비밀번호
	private String password;
	// 회원 이름
	@Size(max=10)
	@Pattern(regexp="^[_0-9a-z가-힣-]*$/i")
	private String name;
	// 계정 등록 일자
	private String regDate;
}
