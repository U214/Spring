package com.srm.domain;

import java.util.Date;

// PC ��Ʈ��ũ ���� VO
public class PcNetworkVO {
	// PC �ڵ�
	private String pcCode;
	// ���� ��
	private int receivedAmount;
	// ���� ��
	private int sentAmount;
	// Ʈ���� �� �հ�
	private int totalAmount;
	// ������ ��� ����
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
