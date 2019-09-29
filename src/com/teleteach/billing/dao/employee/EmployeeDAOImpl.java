package com.teleteach.billing.dao.employee;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.teleteach.billing.dao.DbConstantQueries;
import com.teleteach.billing.vo.EmployeeVO;

public class EmployeeDAOImpl implements EmployeeDAO, DbConstantQueries {

	Connection con;
	PreparedStatement pstmt;
	ResultSet rs;
	DataSource ds = new DataSource();


	@Override
	public List<EmployeeVO> getAllEmployee() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public EmployeeVO getEmployeeById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public EmployeeVO getEmployeeByIdAndMobile1(int id, String password) 
	{
		EmployeeVO employeeVO = null;
		try 
		{
			con = ds.getConnection();
			pstmt = con.prepareStatement(GET_EMPLOYEE_BY_ID_DOB);
			pstmt.setInt(1, id);
			pstmt.setString(2, password);
			rs = pstmt.executeQuery();  
			while (rs.next()) 
			{   
				employeeVO= new EmployeeVO();
				employeeVO.setId(rs.getInt("id"));
				employeeVO.setPassword(rs.getString("password"));
				employeeVO.setFname(rs.getString("fname"));
				employeeVO.setLname(rs.getString("lname"));
				employeeVO.setGender(rs.getString("gender"));
				employeeVO.setAddress(rs.getString("address"));
				employeeVO.setMobile1(rs.getString("mobile1"));
				employeeVO.setMobile2(rs.getString("mobile2"));
				employeeVO.setDob(rs.getDate("dob"));
				employeeVO.setDeg(rs.getInt("deg"));
				employeeVO.setDel_flag(rs.getString("del_flag"));
				employeeVO.setCreate_id(rs.getInt("create_id"));
				employeeVO.setCreate_time(rs.getDate("create_time"));
				employeeVO.setUpdate_id(rs.getInt("update_id"));
				employeeVO.setUpdate_time(rs.getDate("update_time"));
			}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		} 
		catch (ClassNotFoundException e) 
		{
			e.printStackTrace();
		}
		finally {
			try {
				rs.close();
				pstmt.close(); 
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}                      
				}
		return employeeVO;		
	}


}


