package com.teleteach.billing.dao;

public interface DbConstantQueries {
	public static final String GET_EMPLOYEE_BY_ID_DOB = "select * from employee where id=? and password=? and del_flag='N'";
	

}
