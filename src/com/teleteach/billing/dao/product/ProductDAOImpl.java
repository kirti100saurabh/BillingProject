package com.teleteach.billing.dao.product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.teleteach.billing.dao.DataSource;
import com.teleteach.billing.dao.DbConstantQueries;
import com.teleteach.billing.vo.DisplayProductVO;
import com.teleteach.billing.vo.ProductSearchVO;

public class ProductDAOImpl implements ProductDAO, DbConstantQueries{
	Connection con;
	PreparedStatement pstmt;
	ResultSet rs;
	DataSource ds = new DataSource();
	
	
	@Override
	public List<DisplayProductVO> getProduct(){
		DisplayProductVO displayProductVO = null;
		List<DisplayProductVO> listProduct = new ArrayList<DisplayProductVO>();
		try{
			con = ds.getConnection();
			pstmt = con.prepareStatement(DISPLAY_PRODUCT);
			rs= pstmt.executeQuery();
			while(rs.next())
			{
				displayProductVO = new DisplayProductVO();
								
				String productId = Integer.toString(rs.getInt("pid"));
				displayProductVO.setProductId(productId);
				
				displayProductVO.setProductName(rs.getString("pname"));
				
				displayProductVO.setSupplierName(rs.getString("name"));
				
				String available = Integer.toString(rs.getInt("avail"));
				displayProductVO.setAvailable(available);
				
				String productRate = Float.toString(rs.getFloat("prate"));
				displayProductVO.setProductRate(productRate);
				
								
				listProduct.add(displayProductVO);
				
			}
		}catch(SQLException e){
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
		return listProduct;
		
	}
	

	
	
	
	
	@Override
	public List<ProductSearchVO> getProductById(int productsId) {
		ProductSearchVO productSearchVO = null;
		List<ProductSearchVO> listSearchProduct = new ArrayList<ProductSearchVO>();
		try{
			con = ds.getConnection();
			pstmt = con.prepareStatement(PRODUCT_SEARCH_BY_ID);
			pstmt.setInt(1, productsId);
			rs= pstmt.executeQuery();
			while(rs.next())
			{
				productSearchVO = new ProductSearchVO();
				String grnNo = Integer.toString(rs.getInt("grnno"));
				productSearchVO.setGrnNo(grnNo);
				
				String productId = Integer.toString(rs.getInt("pid"));
				productSearchVO.setProductId(productId);
				
				productSearchVO.setProductName(rs.getString("pname"));
				
				String productRate = Float.toString(rs.getFloat("prate"));
				productSearchVO.setProductRate(productRate);
				
				String quantity = Integer.toString(rs.getInt("quantity"));
				productSearchVO.setQuantity(quantity);
				
				productSearchVO.setSupplierName(rs.getString("sname"));
				
				listSearchProduct.add(productSearchVO);
				
			}
		}catch(SQLException e){
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
		return listSearchProduct;
		
}
	

	
	
	
	
	@Override
	public List<ProductSearchVO> getProductByName(String productName) {
		ProductSearchVO productSearchVO = null;
		List<ProductSearchVO> listSearchProduct = new ArrayList<ProductSearchVO>();
		try{
			con = ds.getConnection();
			pstmt = con.prepareStatement(PRODUCT_SEARCH_BY_NAME);
			pstmt.setString(1, "%" +productName+ "%");
			rs= pstmt.executeQuery();
			while(rs.next())
			{
				productSearchVO = new ProductSearchVO();
				String grnNo = Integer.toString(rs.getInt("grnno"));
				productSearchVO.setGrnNo(grnNo);
				
				String productId = Integer.toString(rs.getInt("pid"));
				productSearchVO.setProductId(productId);
				
				productSearchVO.setProductName(rs.getString("pname"));
				
				String productRate = Float.toString(rs.getFloat("prate"));
				productSearchVO.setProductRate(productRate);
				
				String quantity = Integer.toString(rs.getInt("quantity"));
				productSearchVO.setQuantity(quantity);
				
				productSearchVO.setSupplierName(rs.getString("sname"));
				
				listSearchProduct.add(productSearchVO);
				
			}
		}catch(SQLException e){
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
		return listSearchProduct;
		
	}

}
