package com.srm.domain;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

// ����� ���� VO
public class UserVO {
	// ����� ���̵�
	@Size(max=25)
	@Pattern(regexp="^[0-9a-zA-Z][0-9a-zA-Z\\_\\-\\.\\+]+[0-9a-zA-Z]@[0-9a-zA-Z][0-9a-zA-Z\\_\\-]*[0-9a-zA-Z](\\.[a-zA-Z]{2,6}){1,2}$") 
	private String id;
	// ����� ��ȣ
	private String password;
	// ����� �̸�
	@Size(max=10)
	@Pattern(regexp="^[_0-9a-z��-�Ӱ�-�R-]*$/i")
	private String name;
	// ���� ��� ����
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
