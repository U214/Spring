package com.srm.domain;

import java.util.Date;

// PC �ǽð� ���� VO
public class PcRealTimeVO {
	// PC �ڵ�
	private String pcCode;
	// CPU ��뷮
	private int cpuUsage;
	// CPU �µ�1
	private int cpuTemperature1;
	// CPU �µ�2
	private int cpuTemperature2;
	// ��ũ ��뷮
	private int diskUsage;
	// �޸� ��뷮
	private int memoryUsage;
	// ���� �޸� ��뷮
	private int virtualMemoryUsage;
	// ������ ��� ����
	private Date dataRegDate;
	
	public String getPcCode() {
		return pcCode;
	}
	public void setPcCode(String pcCode) {
		this.pcCode = pcCode;
	}
	public int getCpuUsage() {
		return cpuUsage;
	}
	public void setCpuUsage(int cpuUsage) {
		this.cpuUsage = cpuUsage;
	}
	public int getCpuTemperature1() {
		return cpuTemperature1;
	}
	public void setCpuTemperature1(int cpuTemperature1) {
		this.cpuTemperature1 = cpuTemperature1;
	}
	public int getCpuTemperature2() {
		return cpuTemperature2;
	}
	public void setCpuTemperature2(int cpuTemperature2) {
		this.cpuTemperature2 = cpuTemperature2;
	}
	public int getDiskUsage() {
		return diskUsage;
	}
	public void setDiskUsage(int diskUsage) {
		this.diskUsage = diskUsage;
	}
	public int getMemoryUsage() {
		return memoryUsage;
	}
	public void setMemoryUsage(int memoryUsage) {
		this.memoryUsage = memoryUsage;
	}
	public int getVirtualMemoryUsage() {
		return virtualMemoryUsage;
	}
	public void setVirtualMemoryUsage(int virtualMemoryUsage) {
		this.virtualMemoryUsage = virtualMemoryUsage;
	}
	public Date getDataRegDate() {
		return dataRegDate;
	}
	public void setDataRegDate(Date dataRegDate) {
		this.dataRegDate = dataRegDate;
	}
	
	@Override
	public String toString() {
		return "PcRealTimeVO [pcCode=" + pcCode + ", cpuUsage=" + cpuUsage + ", cpuTemperature1=" + cpuTemperature1
				+ ", cpuTemperature2=" + cpuTemperature2 + ", diskUsage=" + diskUsage + ", memoryUsage=" + memoryUsage
				+ ", virtualMemoryUsage=" + virtualMemoryUsage + ", dataRegDate=" + dataRegDate + "]";
	}
}
