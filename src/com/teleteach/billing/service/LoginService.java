package com.teleteach.billing.service;

import com.teleteach.billing.dao.employee.EmployeeDAO;
import com.teleteach.billing.dao.employee.EmployeeDAOImpl;
import com.teleteach.billing.vo.EmployeeVO;

public class LoginService {
	EmployeeDAO employeeDAO = new EmployeeDAOImpl();

	public EmployeeVO validateAndGetEmployeeDetail(int id, String password)
	{
		EmployeeVO employeeVo = employeeDAO.getEmployeeByIdAndPassword(id, password);
		return employeeVo;
	}
}

