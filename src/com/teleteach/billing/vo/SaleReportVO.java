package com.teleteach.billing.vo;

public class SaleReportVO {
	private String billNo;
	private String customerName;
	private String billAmount;
	private String date;
	public String getBillNo() {
		return billNo;
	}
	public void setBillNo(String billNo) {
		this.billNo = billNo;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getBillAmount() {
		return billAmount;
	}
	public void setBillAmount(String billAmount) {
		this.billAmount = billAmount;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	@Override
	public String toString() {
		return "SaleReportVO [billNo=" + billNo + ", customerName=" + customerName + ", billAmount=" + billAmount
				+ ", date=" + date + "]";
	}
	

}
