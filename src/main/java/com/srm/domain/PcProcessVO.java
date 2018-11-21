package com.srm.domain;

import java.util.Date;

//PC 프로세스 정보 VO
public class PcProcessVO {
	// PC 코드
	private String pcCode;
	// 프로세스명
	private String processName;
	// 프로세스 생성 일자
	private Date createDate;
	// 프로세스 메모리 사용량
	private int memoryUsage;
	// 데이터 등록 일자
	private Date dataRegDate;
	
	public String getPcCode() {
		return pcCode;
	}
	public void setPcCode(String pcCode) {
		this.pcCode = pcCode;
	}
	public String getProcessName() {
		return processName;
	}
	public void setProcessName(String processName) {
		this.processName = processName;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public int getMemoryUsage() {
		return memoryUsage;
	}
	public void setMemoryUsage(int memoryUsage) {
		this.memoryUsage = memoryUsage;
	}
	public Date getDataRegDate() {
		return dataRegDate;
	}
	public void setDataRegDate(Date dataRegDate) {
		this.dataRegDate = dataRegDate;
	}
	
	@Override
	public String toString() {
		return "PcProcessVO [pcCode=" + pcCode + ", processName=" + processName + ", createDate=" + createDate
				+ ", memoryUsage=" + memoryUsage + ", dataRegDate=" + dataRegDate + "]";
	}
}
