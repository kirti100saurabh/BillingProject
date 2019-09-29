package com.teleteach.billing.vo;

import java.util.List;

public class CartVO {
	
	CustomerVO customerVO;
	List<ItemVO> itemList;
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
		return "CartVO [customerVO=" + customerVO + ", itemList=" + itemList + "]";
	}
	
}
