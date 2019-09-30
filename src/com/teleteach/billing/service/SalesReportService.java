package com.teleteach.billing.service;

import java.util.List;

import com.teleteach.billing.dao.repot.SalesReportDAO;
import com.teleteach.billing.dao.repot.SalesReportDAOImpl;
import com.teleteach.billing.vo.SaleReportVO;

public class SalesReportService 
{
	SalesReportDAO salesReportDAO = new SalesReportDAOImpl();

	public List<SaleReportVO> getSalesReport(int month, int startDate)
	{
		List<SaleReportVO> listSaleReport = salesReportDAO.getSalesReport(month, startDate);
		return listSaleReport==null? null: listSaleReport;
		
		
	}
	public static void main(String[] args) {
		SalesReportService salesReportService = new SalesReportService();
		salesReportService.getSalesReport(9, 29);
			}

	
}
