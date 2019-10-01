package com.teleteach.billing.service;

import java.util.List;

import com.teleteach.billing.dao.repot.CustomerReportDAO;
import com.teleteach.billing.dao.repot.CustomerReportDAOImpl;
import com.teleteach.billing.vo.CustomerReportVO;

public class CustomerReportService 
{
	CustomerReportDAO customerReportDAO = new CustomerReportDAOImpl();

	public List<CustomerReportVO> getCustomerReport()
	{
		List<CustomerReportVO> listCustomerReport = customerReportDAO.getCustomerReport();
		return listCustomerReport==null? null: listCustomerReport;
		
		
	}
	public static void main(String[] args) {
		CustomerReportService customerReportService = new CustomerReportService();
		customerReportService.getCustomerReport();
	}

	
}
