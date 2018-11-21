package com.srm.domain;

import java.util.Date;

//PC 실시간 정보 VO
public class PcRealTimeVO {
	// PC 코드
	private String pcCode;
	// CPU 사용량
	private int cpuUsage;
	// CPU 온도1
	private int cpuTemperature1;
	// CPU 온도2
	private int cpuTemperature2;
	// 디스크 사용량
	private int diskUsage;
	// 메모리 사용량
	private int memoryUsage;
	// 가상 메모리 사용량
	private int virtualMemoryUsage;
	// 데이터 등록 일자
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
