package com.eval.coronakit.service;

import java.util.List;

import com.eval.coronakit.entity.ProductMaster;
import com.eval.coronakit.exception.CoronaException;

public interface ProductService {

	public ProductMaster addNewProduct(ProductMaster product) throws CoronaException;
	public List<ProductMaster> getAllProducts() throws CoronaException;
	public String deleteProduct(int productId) throws CoronaException;
	public ProductMaster getProductById(int productId) throws CoronaException;
}
