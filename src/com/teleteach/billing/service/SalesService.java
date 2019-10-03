package com.teleteach.billing.service;

import com.teleteach.billing.vo.SaleVO;

public class SalesService {
	public int maxBillNo()
	{
		SaleVO saleVO = new SaleVO();
		int billNO = saleVO.getBillNo();
		if (billNO == 0)
		{
			return 1;
		}
		else 
		{
		return billNO;
		}
	}	
}
