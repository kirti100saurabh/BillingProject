package com.teleteach.billing.dao.repot;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.teleteach.billing.dao.DataSource;
import com.teleteach.billing.dao.DbConstantQueries;
import com.teleteach.billing.vo.SaleReportVO;

public class SalesReportDAOImpl implements SalesReportDAO, DbConstantQueries {
	Connection con;
	PreparedStatement pstmt;
	ResultSet rs;
	DataSource ds = new DataSource();
	
	@Override
	public List<SaleReportVO> getSalesReport(int month, int startDate)
	{
		SaleReportVO saleReportVO = null;
		List<SaleReportVO> listSaleReport = new ArrayList<SaleReportVO>();
		try 
		{
			con = ds.getConnection();
			pstmt = con.prepareStatement(SAlE_REPROT);
			pstmt.setInt(1,startDate );
			pstmt.setInt(2, startDate+6);
			pstmt.setInt(3, month);
			rs = pstmt.executeQuery(); 			
			while (rs.next()) 
			{   
				saleReportVO = new SaleReportVO();
				String billNo = Integer.toString(rs.getInt("BILLNO"));
				saleReportVO.setBillNo(billNo);
				saleReportVO.setCustomerName(rs.getString("CustomerName"));
				String billAmount = Integer.toString(rs.getInt("BILL"));
				saleReportVO.setBillAmount(billAmount);
				saleReportVO.setDate(rs.getString("saledate"));
				listSaleReport.add(saleReportVO);			
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
		return listSaleReport;
		
		
	}

}
