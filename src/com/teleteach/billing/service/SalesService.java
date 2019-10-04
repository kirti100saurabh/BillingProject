package com.teleteach.billing.service;

import java.util.List;

import com.teleteach.billing.dao.sales.SalesNonRegisteredCustomerDAO;
import com.teleteach.billing.dao.sales.SalesNonRegisteredCustomerDAOImpl;
import com.teleteach.billing.vo.SaleVO;

public class SalesService {
	SalesNonRegisteredCustomerDAO salesNonRegisteredCustomerDAO = new SalesNonRegisteredCustomerDAOImpl();
	public int maxBillNo()
	{
		int billNO = salesNonRegisteredCustomerDAO.getMaxBillNo();
		if (billNO == 0)
		{
			return 1;
		}
		else 
		{
		return billNO;
		}
	}
	
	public List<SaleVO> getNameAndRate(int productID){
		List<SaleVO> listNameAndRate = salesNonRegisteredCustomerDAO.getNameAndRate(productID);
		return listNameAndRate==null? null: listNameAndRate;
	}
	
	public int getProductQuantity(int productId){
		int prodictQuantity = salesNonRegisteredCustomerDAO.getProductQuantity(productId);
		return prodictQuantity;
	}

	public void setIntoSales1Table(int billno, double bill, float discount) {
		salesNonRegisteredCustomerDAO.setIntoSales1Table(billno, bill, discount);
		
	}
}
