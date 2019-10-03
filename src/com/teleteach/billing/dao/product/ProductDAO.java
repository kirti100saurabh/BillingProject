package com.teleteach.billing.dao.product;

import java.util.List;

import com.teleteach.billing.vo.DisplayProductVO;
import com.teleteach.billing.vo.ProductSearchVO;

public interface ProductDAO {
	public List<DisplayProductVO> getProduct();
	public List<ProductSearchVO> getProductById(int productsId);
	public List<ProductSearchVO> getProductByName(String productName);
	

}
