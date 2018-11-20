package com.srm.domain;

import java.util.Date;

// PC ���μ��� ���� VO
public class PcProcessVO {
	// PC �ڵ�
	private String pcCode;
	// ���μ�����
	private String processName;
	// ���μ��� ���� ����
	private Date createDate;
	// ���μ��� �޸� ��뷮
	private int memoryUsage;
	// ������ ��� ����
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
