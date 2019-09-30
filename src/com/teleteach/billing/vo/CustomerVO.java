package com.teleteach.billing.vo;

public class CustomerVO {
	
	private String id;
	private String name;
	private String address;
	private String mobileNo;
	public String getId() {
		return id;
	}
	public void setId(String string) {
		this.id = string;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getMobileNo() {
		return mobileNo;
	}
	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}
	@Override
	public String toString() {
		return "CustomerVO [id=" + id + ", name=" + name + ", address=" + address + ", mobileNo=" + mobileNo + "]";
	}
	

}
