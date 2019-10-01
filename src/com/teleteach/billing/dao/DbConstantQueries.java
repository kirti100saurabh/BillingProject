package com.teleteach.billing.dao;

public interface DbConstantQueries {
	public static final String GET_EMPLOYEE_BY_ID_DOB = "select * from employee where id=? and password=? and del_flag='N'";
	
	
	public static final String CUSTOMER_REPORT = "select ID,NAME,MOBNO,sum(balance) as CREDIT, sum(amount) as DEBIT from"
			+ " customr natural join sale1 natural join customerdebit group by (id)order by id";
	
	public static final String PURCHASE_REPORT = "select GRNNO,SNAME as SupplierName,BILL,purch_date_time as PurchaseDate from"
			+ " purchase1 natural join supplier where extract(day from purch_date_time) between ? AND ? and"
			+ " extract(month from purch_date_time)=?";
	
	
	public static final String SAlE_REPROT ="select BILLNO,NAME as CustomerName,BILL,sale_date as saledate from"
			+ " sale1 natural join customr where extract(day from sale_date) between ? AND ? and"
					+ " extract(month from sale_date)=?";
}
