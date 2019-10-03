package com.teleteach.billing.dao;

import javacode.CustomerPurchase;

public interface DbConstantQueries {
	public static final String GET_EMPLOYEE_BY_ID_DOB = "select * from employee where id=? and password=? and del_flag='N'";
	
	/*Queries for report generation.*/
	
	public static final String CUSTOMER_REPORT = "select ID,NAME,MOBNO,sum(balance) as CREDIT, sum(amount) as DEBIT from"
			+ " customr natural join sale1 natural join customerdebit group by (id)order by id";
	
	public static final String PURCHASE_REPORT = "select GRNNO,SNAME as SupplierName,BILL,purch_date_time as PurchaseDate from"
			+ " purchase1 natural join supplier where extract(day from purch_date_time) between ? AND ? and"
			+ " extract(month from purch_date_time)=?";
	
	
	public static final String SAlE_REPROT ="select BILLNO,NAME as CustomerName,BILL,sale_date as saledate from"
			+ " sale1 natural join customr where extract(day from sale_date) between ? AND ? and"
					+ " extract(month from sale_date)=?";

	/*Queries for Product search*/
	
	public static final String DISPLAY_PRODUCT = "SELECT pid,pname,name,avail,prate FROM available1 natural join product1 natural join company1";
	
	public static final String PRODUCT_SEARCH_BY_ID = "SELECT grnno,pid,pname,prate,quantity,sname FROM "
			+ " product1 natural join prod_purch natural join purchase1 natural join supplier where pid = ?";
	
	public static final String PRODUCT_SEARCH_BY_NAME ="SELECT grnno,pid,pname,prate,quantity,sname FROM "
			+ " product1 natural join prod_purch natural join purchase1 natural join supplier where pname"
			+ " like ?";
	public static final String SEARCH_BY_PRODUCT_BARCODE ="select pid from product1 where barcode = ?";
	
	
	/* Queries for sales */
			public static final String MAX_BILL_NO = "SELECT MAX(billno) FROM sale1";
			public static final String DISTINCT_PRODUCTNAME = "select distinct pname from product1";
			/*public static final String SEARCH_BY_PRODUCTID = "select pname,prate from product1 where pid="+tfId.getText());
			public static final String SEARCH_BY_PRODUCTNAME = "select pid from product1 where pname='"+name+"'");
			public static final String SEARCH_BY_PRODUCTBARCODE ="select pid from product1 where barcode='"+st+"'");
			
			public static final String CHECK_PRODUCT_AVAILABILITY = ""select avail from Available1 where pid="+tfId.getText());"
			
			
			public static final String SAVE_SALES_TO_SALES1 = "insert into sale1 values"
					+ "(" + billno + ",0," + bill+ ",sysdate,"+tfDisc.getText()+","+id+")");
			public static final String SAVE_SALES_TO_CUSTOMERDEBIT = ""insert into CustomerDebit values"
					("+CustomerPurchase.calc()+","+billno+","+tfCash.getText()+",curdate());
			public static final String SAVE_SALES_TO_CUSTOMERPURCHASE = "insert into cust_purch values("
					+ data.get(i).get(0) + "," + billno + "," + data.get(i).get(3) + ")");
			*/
			
	


}



