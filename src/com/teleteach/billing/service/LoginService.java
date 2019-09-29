package com.teleteach.billing.service;

import com.teleteach.billing.dao.employee.EmployeeDAO;
import com.teleteach.billing.dao.employee.EmployeeDAOImpl;
import com.teleteach.billing.vo.EmployeeVO;

public class LoginService {
	EmployeeDAO employeeDAO = new EmployeeDAOImpl();

	public int validateAndGetDesignation(int id, String password){
		EmployeeVO employeeVo = employeeDAO.getEmployeeByIdAndMobile1(id, password);
		if(employeeVo==null)
		{
			return 0;
		}
		else if(employeeVo.getDeg()==1)
		{
			return 1;
		}
		else if(employeeVo.getDeg()==2)
		{
			return 2;
		} 
		else if(employeeVo.getDeg()==3)
		{
			return 3;
		} 
		return -1;
	}



}
