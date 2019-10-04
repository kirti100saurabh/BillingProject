package com.teleteach.billing.vo;

public class SaleVO {
	private int billNo;
	private static String productName;
	private static float productRate;
	private static int productQuantity;

	public static String getProductName() {
		return productName;
	}

	public static int getProductQuantity() {
		return productQuantity;
	}

	public static void setProductQuantity(int productQuantity) {
		SaleVO.productQuantity = productQuantity;
	}

	public void setProductName(String productName) {
		SaleVO.productName = productName;
	}

	public static float getProductRate() {
		return productRate;
	}

	public void setProductRate(float productRate) {
		SaleVO.productRate = productRate;
	}

	public int getBillNo() {
		return billNo;
	}

	public void setBillNo(int billNo) {
		this.billNo = billNo;
	}

	@Override
	public String toString() {
		return "SaleVO [billNo=" + billNo + "]";
	}

}
	


