package com.teleteach.billing.dao.sales;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.teleteach.billing.dao.DataSource;
import com.teleteach.billing.dao.DbConstantQueries;
import com.teleteach.billing.vo.SaleVO;

public class SalesNonRegisteredCustomerDAOImpl implements SalesNonRegisteredCustomerDAO, DbConstantQueries {
	Connection con;
	PreparedStatement pstmt;
	ResultSet rs;
	DataSource ds = new DataSource();
	
	@Override
	public int getMaxBillNo() {
		SaleVO saleVO = null;
		try
		{
			con = ds.getConnection();
			pstmt = con.prepareStatement(MAX_BILL_NO);
			rs= pstmt.executeQuery();
			while(rs.next())
			{
				saleVO= new SaleVO();
				saleVO.setBillNo(rs.getInt("billno"));				
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return 0;
	}

}
