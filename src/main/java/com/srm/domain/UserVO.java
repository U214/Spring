package com.srm.domain;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

// 회원 정보 VO
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
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRegDate() {
		return regDate;
	}
	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Override
	public String toString() {
		return "UserVO [email=" + email + ", password=" + password + ", name=" + name + ", regDate=" + regDate + "]";
	}
}
