package com.srm.domain;

// PC 기본 정보 VO
public class PcInfoVO {
	// PC 코드
	private String pcCode;
	// PC 이름
	private String pcName;
	// MAC주소
	private String macAddress;
	// IP주소
	private String ipAddress;
	// 사용자 아이디
	private String userId;
	
	public String getPcCode() {
		return pcCode;
	}
	public void setPcCode(String pcCode) {
		this.pcCode = pcCode;
	}
	public String getPcName() {
		return pcName;
	}
	public void setPcName(String pcName) {
		this.pcName = pcName;
	}
	public String getMacAddress() {
		return macAddress;
	}
	public void setMacAddress(String macAddress) {
		this.macAddress = macAddress;
	}
	public String getIpAddress() {
		return ipAddress;
	}
	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	@Override
	public String toString() {
		return "PcInfoVO [pcCode=" + pcCode + ", pcName=" + pcName + ", macAddress=" + macAddress + ", ipAddress="
				+ ipAddress + ", userId=" + userId + "]";
	}
}
