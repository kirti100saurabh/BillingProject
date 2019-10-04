package com.teleteach.billing.dao.sales;

import java.util.List;

import com.teleteach.billing.vo.SaleVO;

public interface SalesNonRegisteredCustomerDAO {
	public int getMaxBillNo();
	public List<SaleVO> getNameAndRate(int productID);
	public int getProductQuantity(int productId);
	public void setIntoSales1Table(int billno, double bill, float discount);

}
