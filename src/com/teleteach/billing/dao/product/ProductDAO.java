package com.teleteach.billing.dao.product;

import java.util.List;

import com.teleteach.billing.vo.ProductSearchVO;

public interface ProductDAO {
	public List<ProductSearchVO> getProductById(int productId);
	public List<ProductSearchVO> getProductByName(String productName);

}
