package com.teleteach.billing.dao.report;

import java.util.List;

import com.teleteach.billing.vo.SaleReportVO;

public interface SalesReportDAO {
	public List<SaleReportVO> getSalesReport(int month,int startDate);
	
}
