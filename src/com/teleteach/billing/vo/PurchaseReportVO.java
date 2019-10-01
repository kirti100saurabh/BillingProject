package com.teleteach.billing.vo;

public class PurchaseReportVO {
	private String GRNNO;
	private String SupplierName;
	private String BILL;
	private String PurchaseDate;
	public String getGRNNO() {
		return GRNNO;
	}
	public void setGRNNO(String gRNNO) {
		GRNNO = GRNNO;
	}
	public String getSupplierName() {
		return SupplierName;
	}
	public void setSupplierName(String supplierName) {
		SupplierName = supplierName;
	}
	public String getBILL() {
		return BILL;
	}
	public void setBILL(String bILL) {
		BILL = bILL;
	}
	public String getPurchaseDate() {
		return PurchaseDate;
	}
	public void setPurchaseDate(String purchaseDate) {
		PurchaseDate = purchaseDate;
	}
	@Override
	public String toString() {
		return "PurchaseReportVO [GRNNO=" + GRNNO + ", SupplierName=" + SupplierName + ", BILL=" + BILL
				+ ", PurchaseDate=" + PurchaseDate + "]";
	}
	
	}
	


