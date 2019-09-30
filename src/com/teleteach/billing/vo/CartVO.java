package com.teleteach.billing.vo;

import java.util.List;

public class CartVO {
	
	CustomerVO customerVO;
	List<ItemVO> itemList;
	private int billNO;
	public int getBillNO() {
		return billNO;
	}
	public void setBillNO(int billNO) {
		this.billNO = billNO;
	}
	public CustomerVO getCustomerVO() {
		return customerVO;
	}
	public void setCustomerVO(CustomerVO customerVO) {
		this.customerVO = customerVO;
	}
	public List<ItemVO> getItemList() {
		return itemList;
	}
	public void setItemList(List<ItemVO> itemList) {
		this.itemList = itemList;
	}
	@Override
	public String toString() {
		return "CartVO [customerVO=" + customerVO + ", itemList=" + itemList + ", billNO=" + billNO + "]";
	}
	
}
