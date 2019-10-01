package com.teleteach.billing.dao.repot;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.teleteach.billing.dao.DataSource;
import com.teleteach.billing.dao.DbConstantQueries;
import com.teleteach.billing.vo.CustomerReportVO;

public class CustomerReportDAOImpl implements CustomerReportDAO, DbConstantQueries{
	Connection con;
	PreparedStatement pstmt;
	ResultSet rs;
	DataSource ds = new DataSource();
	@Override
	public List<CustomerReportVO> getCustomerReport() {
		
		CustomerReportVO customerReportVO = null;
		List<CustomerReportVO> listCustomerReport = new ArrayList<CustomerReportVO>();
		try 
		{
			con = ds.getConnection();
			pstmt = con.prepareStatement(CUSTOMER_REPORT);
			//pstmt.setInt(1, ids );
			rs = pstmt.executeQuery(); 			
			while (rs.next()) 
			{   
				customerReportVO = new CustomerReportVO();
				
				String id = Integer.toString(rs.getInt("id"));
				customerReportVO.setId(rs.getString("id"));
				
				customerReportVO.setName(rs.getString("name"));
				
				customerReportVO.setMobno(rs.getString("mobno"));
				
				String credit = Float.toString(rs.getFloat("credit"));
				customerReportVO.setCredit(rs.getString("credit"));
								
				String debit = Float.toString(rs.getFloat("debit"));
				customerReportVO.setCredit(rs.getString("debit"));
				
				
				listCustomerReport.add(customerReportVO);			
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
		finally 
		{
			try {
				rs.close();
				pstmt.close(); 
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}                      
		}
		return listCustomerReport;
		
		
	}
		
}


