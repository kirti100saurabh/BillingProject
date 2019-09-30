package com.teleteach.billing.dao.employee;

import java.util.List;

import com.teleteach.billing.vo.EmployeeVO;

public interface EmployeeDAO {
	
	public List<EmployeeVO> getAllEmployee();
	public EmployeeVO getEmployeeById(int id);
	public EmployeeVO getEmployeeByIdAndPassword(int id, String password);
	

}
