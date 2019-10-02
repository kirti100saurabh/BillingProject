package com.teleteach.billing.service;

import java.util.List;

import com.teleteach.billing.dao.product.ProductDAO;
import com.teleteach.billing.dao.product.ProductDAOImpl;
import com.teleteach.billing.vo.ProductSearchVO;

public class ProductSearchService {
	
	ProductDAO productDAO = new ProductDAOImpl();
	
	public List<ProductSearchVO> searchProductByName(String productName){
		List<ProductSearchVO> listSearchProduct = productDAO.getProductByName(productName);
		return listSearchProduct==null? null: listSearchProduct;
				
		
	}
	
	public static void main(String[] args) {
		ProductSearchService productSearchService = new ProductSearchService();
		List<ProductSearchVO> list =productSearchService.searchProductByName("laptop");
		System.out.println(list);
	}

}
