package com.teleteach.billing.dao.report;

import java.util.List;

import com.teleteach.billing.vo.PurchaseReportVO;

public interface PurchaseReportDAO {
	public List<PurchaseReportVO> getPurchaseReport(int month,int startDate);
	
}
