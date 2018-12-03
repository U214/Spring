package com.srm.domain;

import java.util.Date;

import lombok.Data;

//PC 상세 정보 VO
@Data
public class PcDetailVO {
	// PC 코드
	private String pcCode;
	// 기존 데이터 존재 여부 플래그
	private boolean dataCheckFlag;
	// 제조사명
	private String makerName;
	// 모델명
	private String modelName;
	// OS명
	private String osName;
	// BIOS명
	private String biosName;
	// 디스크 전체 용량
	private int diskSize;
	// 메모리 전체 용량
	private int memorySize;
	// 가상 메모리 전체 용량
	private int virtualMemorySize;
	// 설치 일자
	private Date installDate;
}
