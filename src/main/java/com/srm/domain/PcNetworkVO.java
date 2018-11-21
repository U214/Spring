package com.srm.domain;

import java.util.Date;

//PC 네트워크 정보 VO
public class PcNetworkVO {
	// PC 코드
	private String pcCode;
	// 받은 양
	private int receivedAmount;
	// 보낸 양
	private int sentAmount;
	// 트래픽 양 합계
	private int totalAmount;
	// 데이터 등록 일자
	private Date dataRegdate;
	
	public String getPcCode() {
		return pcCode;
	}
	public void setPcCode(String pcCode) {
		this.pcCode = pcCode;
	}
	public int getReceivedAmount() {
		return receivedAmount;
	}
	public void setReceivedAmount(int receivedAmount) {
		this.receivedAmount = receivedAmount;
	}
	public int getSentAmount() {
		return sentAmount;
	}
	public void setSentAmount(int sentAmount) {
		this.sentAmount = sentAmount;
	}
	public int getTotalAmount() {
		return totalAmount;
	}
	public void setTotalAmount(int totalAmount) {
		this.totalAmount = totalAmount;
	}
	public Date getDataRegdate() {
		return dataRegdate;
	}
	public void setDataRegdate(Date dataRegdate) {
		this.dataRegdate = dataRegdate;
	}
	
	@Override
	public String toString() {
		return "PcNetworkVO [pcCode=" + pcCode + ", receivedAmount=" + receivedAmount + ", sentAmount=" + sentAmount
				+ ", totalAmount=" + totalAmount + ", dataRegdate=" + dataRegdate + "]";
	}
}
