package com.srm.domain;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

// 사용자 정보 VO
public class UserVO {
	// 사용자 아이디
	@Size(max=25)
	@Pattern(regexp="^[0-9a-zA-Z][0-9a-zA-Z\\_\\-\\.\\+]+[0-9a-zA-Z]@[0-9a-zA-Z][0-9a-zA-Z\\_\\-]*[0-9a-zA-Z](\\.[a-zA-Z]{2,6}){1,2}$") 
	private String id;
	// 사용자 암호
	private String password;
	// 사용자 이름
	@Size(max=10)
	@Pattern(regexp="^[_0-9a-zㄱ-ㅣ가-힣-]*$/i")
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
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	@Override
	public String toString() {
		return "UserVO [id=" + id + ", password=" + password + ", name=" + name + ", regDate=" + regDate + "]";
	}
}
