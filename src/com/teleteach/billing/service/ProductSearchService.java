package com.teleteach.billing.service;

import java.util.List;

import com.teleteach.billing.dao.product.ProductDAO;
import com.teleteach.billing.dao.product.ProductDAOImpl;
import com.teleteach.billing.vo.DisplayProductVO;
import com.teleteach.billing.vo.ProductSearchVO;

public class ProductSearchService {
	
	ProductDAO productDAO = new ProductDAOImpl();
	
	public List<DisplayProductVO> displayProduct(){
		List<DisplayProductVO> listProduct = productDAO.getProduct();
		return listProduct==null? null: listProduct;
	}
	
	public List<ProductSearchVO> searchProductById(int productsId){
		List<ProductSearchVO> listSearchProduct = productDAO.getProductById(productsId);
		return listSearchProduct==null? null: listSearchProduct;
	}
	
	
	public List<ProductSearchVO> searchProductByName(String productName){
		List<ProductSearchVO> listSearchProduct = productDAO.getProductByName(productName);
		return listSearchProduct==null? null: listSearchProduct;
	}
	
	public static void main(String[] args) {
		ProductSearchService productSearchService = new ProductSearchService();
		List<DisplayProductVO> list =productSearchService.displayProduct();
		System.out.println(list);
	}

}
