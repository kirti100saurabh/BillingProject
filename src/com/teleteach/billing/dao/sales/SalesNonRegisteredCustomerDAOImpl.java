package com.teleteach.billing.dao.sales;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.teleteach.billing.dao.DataSource;
import com.teleteach.billing.dao.DbConstantQueries;
import com.teleteach.billing.vo.SaleVO;

public class SalesNonRegisteredCustomerDAOImpl implements SalesNonRegisteredCustomerDAO, DbConstantQueries {
	Connection con;
	PreparedStatement pstmt;
	ResultSet rs;
	DataSource ds = new DataSource();
	SaleVO saleVO = null;
	@Override
	public int getMaxBillNo() {
		
		try
		{
			con = ds.getConnection();
			pstmt = con.prepareStatement(MAX_BILL_NO);
			rs= pstmt.executeQuery();
			while(rs.next())
			{
				saleVO= new SaleVO();
				saleVO.setBillNo(rs.getInt("MAX(billno)"));				
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return saleVO.getBillNo();
	}
	
	public List<SaleVO> getNameAndRate(int productId){
		
		List<SaleVO> listNameAndRate = new ArrayList<SaleVO>();
		try{	
			con = ds.getConnection();
			pstmt = con.prepareStatement(SEARCH_BY_PRODUCTID);
			pstmt.setInt(1, productId);
			rs= pstmt.executeQuery();
			
			while(rs.next())
			{
				saleVO= new SaleVO();
				
				saleVO.setProductName(rs.getString("pname"));
				saleVO.setProductRate(rs.getFloat("prate"));
				
				listNameAndRate.add(saleVO);
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return listNameAndRate;		
	}

	public int getProductQuantity(int productId){
		try{	
			con = ds.getConnection();
			pstmt = con.prepareStatement(CHECK_PRODUCT_AVAILABILITY);
			pstmt.setInt(1, productId);
			rs= pstmt.executeQuery();
			
			while(rs.next())
			{
				SaleVO.setProductQuantity(rs.getInt("avail"));
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return SaleVO.getProductQuantity();		
		
	}
	
	public void setIntoSales1Table(int billno, double bill, float discount){
		try{	
			con = ds.getConnection();
			pstmt = con.prepareStatement(SAVE_SALES_TO_SALES1);
			System.out.println(billno);
			System.out.println(bill);
			System.out.println(discount);
			
			pstmt.setInt(1, billno);
			pstmt.setFloat(2,(float)bill);
			pstmt.setFloat(3, discount);
			pstmt.execute();
		}
		catch(Exception e){
			e.printStackTrace();
		}
			
	}
}
