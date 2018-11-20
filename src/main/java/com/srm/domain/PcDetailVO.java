package com.srm.domain;

import java.util.Date;

// PC 상세 정보 VO
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
	
	public String getPcCode() {
		return pcCode;
	}
	public void setPcCode(String pcCode) {
		this.pcCode = pcCode;
	}
	public boolean isDataCheckFlag() {
		return dataCheckFlag;
	}
	public void setDataCheckFlag(boolean dataCheckFlag) {
		this.dataCheckFlag = dataCheckFlag;
	}
	public String getMakerName() {
		return makerName;
	}
	public void setMakerName(String makerName) {
		this.makerName = makerName;
	}
	public String getModelName() {
		return modelName;
	}
	public void setModelName(String modelName) {
		this.modelName = modelName;
	}
	public String getOsName() {
		return osName;
	}
	public void setOsName(String osName) {
		this.osName = osName;
	}
	public String getBiosName() {
		return biosName;
	}
	public void setBiosName(String biosName) {
		this.biosName = biosName;
	}
	public int getDiskSize() {
		return diskSize;
	}
	public void setDiskSize(int diskSize) {
		this.diskSize = diskSize;
	}
	public int getMemorySize() {
		return memorySize;
	}
	public void setMemorySize(int memorySize) {
		this.memorySize = memorySize;
	}
	public int getVirtualMemorySize() {
		return virtualMemorySize;
	}
	public void setVirtualMemorySize(int virtualMemorySize) {
		this.virtualMemorySize = virtualMemorySize;
	}
	public Date getInstallDate() {
		return installDate;
	}
	public void setInstallDate(Date installDate) {
		this.installDate = installDate;
	}
	
	@Override
	public String toString() {
		return "PcDetailVO [pcCode=" + pcCode + ", dataCheckFlag=" + dataCheckFlag + ", makerName=" + makerName
				+ ", modelName=" + modelName + ", osName=" + osName + ", biosName=" + biosName + ", diskSize="
				+ diskSize + ", memorySize=" + memorySize + ", virtualMemorySize=" + virtualMemorySize
				+ ", installDate=" + installDate + "]";
	}
}
