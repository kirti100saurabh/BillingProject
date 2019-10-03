package com.teleteach.billing.vo;

public class ProductSearchVO {
	private String grnNo;
	private String productId;
	private String productName;
	private String productRate;
	private String quantity;
	private String supplierName;
	public String getGrnno() {
		return grnNo;
	}
	public void setGrnNo(String grnNo) {
		this.grnNo = grnNo;
	}
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
	public String getProductRate() {
		return productRate;
	}
	public void setProductRate(String productRate) {
		this.productRate = productRate;
	}
	public String getQuantity() {
		return quantity;
	}
	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}
	public String getSupplierName() {
		return supplierName;
	}
	public void setSupplierName(String supplierName) {
		this.supplierName = supplierName;
	}
	@Override
	public String toString() {
		return "ProductSearchVO [grnNo=" + grnNo + ", productId=" + productId + ", productName=" + productName
				+ ", productRate=" + productRate + ", quantity=" + quantity + ", supplierName=" + supplierName + "]";
	}
	
	
	
}
