package com.teleteach.billing.vo;

public class DisplayProductVO {
	private String productId;
	private String productName;
	private String supplierName;
	private String available;
	private String productRate;
	public String getProductId() {
		return productId;
	}
	public void setProductId(String productId) {
		this.productId = productId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getSupplierName() {
		return supplierName;
	}
	public void setSupplierName(String companyName) {
		this.supplierName = companyName;
	}
	public String getAvailable() {
		return available;
	}
	public void setAvailable(String available) {
		this.available = available;
	}
	public String getProductRate() {
		return productRate;
	}
	public void setProductRate(String productRate) {
		this.productRate = productRate;
	}
	@Override
	public String toString() {
		return "DisplayProductVO [productId=" + productId + ", productName=" + productName + ", companyName="
				+ supplierName + ", available=" + available + ", productRate=" + productRate + "]";
	}
	
}
