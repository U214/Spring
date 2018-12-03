package com.srm.domain;

import lombok.Data;

//PC 기본 정보 VO
@Data
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
	private String email;
}
