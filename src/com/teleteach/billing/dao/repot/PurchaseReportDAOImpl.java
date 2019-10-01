package com.teleteach.billing.dao.repot;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import com.teleteach.billing.dao.DataSource;
import com.teleteach.billing.dao.DbConstantQueries;
import com.teleteach.billing.vo.PurchaseReportVO;

public class PurchaseReportDAOImpl implements PurchaseReportDAO, DbConstantQueries {
	Connection con;
	PreparedStatement pstmt;
	ResultSet rs;
	DataSource ds = new DataSource();
	
	@Override
	public List<PurchaseReportVO> getPurchaseReport(int month, int startDate)
	{
		PurchaseReportVO purchaseReportVO = null;
		List<PurchaseReportVO> listPurchaseReport = new ArrayList<PurchaseReportVO>();
		try 
		{
			con = ds.getConnection();
			pstmt = con.prepareStatement(PURCHASE_REPORT);
			pstmt.setInt(1,startDate );
			pstmt.setInt(2, startDate+6);
			pstmt.setInt(3, month);
			rs = pstmt.executeQuery(); 			
			while (rs.next()) 
			{   
				purchaseReportVO = new PurchaseReportVO();
				
				String GRNNO = Integer.toString(rs.getInt("GRNNO"));
				purchaseReportVO.setGRNNO(GRNNO);
				
				purchaseReportVO.setSupplierName(rs.getString("SupplierName"));
				
				String billAmount = Integer.toString(rs.getInt("BILL"));
				purchaseReportVO.setBILL(billAmount);
				
				Time time = rs.getTime("PurchaseDate");
				String PurchaseDate = new SimpleDateFormat("yyyyMMdd").format(time);
				purchaseReportVO.setPurchaseDate("purchaseDate");
				
				
				listPurchaseReport.add(purchaseReportVO);			
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
		return listPurchaseReport;
		
		
	}

}
