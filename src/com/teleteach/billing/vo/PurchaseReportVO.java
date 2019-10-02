package com.teleteach.billing.vo;

public class PurchaseReportVO {
	private String grnNo;
	private String supplierName;
	private String bill;
	private String purchaseDate;
	public String getGrnNo() {
		return grnNo;
	}
	public void setGrnNo(String grnNo) {
		this.grnNo = grnNo;
	}
	public String getSupplierName() {
		return supplierName;
	}
	public void setSupplierName(String supplierName) {
		this.supplierName = supplierName;
	}
	public String getBill() {
		return bill;
	}
	public void setBill(String bill) {
		this.bill = bill;
	}
	public String getPurchaseDate() {
		return purchaseDate;
	}
	public void setPurchaseDate(String purchaseDate) {
		this.purchaseDate = purchaseDate;
	}
	@Override
	public String toString() {
		return "PurchaseReportVO [grnNo=" + grnNo + ", supplierName=" + supplierName + ", bill=" + bill
				+ ", purchaseDate=" + purchaseDate + "]";
	}
	
}
	
	
	


