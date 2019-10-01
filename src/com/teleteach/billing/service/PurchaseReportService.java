package com.teleteach.billing.service;

import java.util.List;

import com.teleteach.billing.dao.repot.PurchaseReportDAO;
import com.teleteach.billing.dao.repot.PurchaseReportDAOImpl;
import com.teleteach.billing.vo.PurchaseReportVO;

public class PurchaseReportService 
{
	PurchaseReportDAO PurchasesReportDAO = new PurchaseReportDAOImpl();

	public List<PurchaseReportVO> getPurchaseReport(int month, int startDate)
	{
		List<PurchaseReportVO> listPurchaseReport = PurchasesReportDAO.getPurchaseReport(month, startDate);
		return listPurchaseReport==null? null: listPurchaseReport;
		
		
	}
	public static void main(String[] args) {
		PurchaseReportService PurchasesReportService = new PurchaseReportService();
		PurchasesReportService.getPurchaseReport(9, 29);
			}

	
}
