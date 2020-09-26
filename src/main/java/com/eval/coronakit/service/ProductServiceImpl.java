package com.eval.coronakit.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eval.coronakit.dao.ProductMasterRepository;
import com.eval.coronakit.entity.ProductMaster;
import com.eval.coronakit.exception.CoronaException;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	ProductMasterRepository repository;

	@Override
	@Transactional
	public ProductMaster addNewProduct(ProductMaster product) throws CoronaException {
		
		if(product!=null) {
			if(repository.existsById(product.getId())) {
				throw new CoronaException("Item code already used!");
			}
			
			repository.save(product);
		}
		return product;
		
	}

	@Override
	@Transactional
	public List<ProductMaster> getAllProducts() throws CoronaException {
		
		return repository.findAll();
	}

	@Override
	@Transactional
	public String deleteProduct(int productId) throws CoronaException {

		if(!repository.existsById(productId)) {
			throw new CoronaException("Product Not Found");
		}
	
		repository.deleteById(productId);
		
		return "Deleted product id - " + productId;
		

	}

	@Override
	@Transactional
	public ProductMaster getProductById(int productId) throws CoronaException {
		Optional<ProductMaster> result = repository.findById(productId);

		ProductMaster theproduct = null;

		if (result.isPresent()) {
			theproduct = result.get();
		} else {
			throw new CoronaException("Did not find employee id - " + productId);
		}

		return theproduct;
	}

}
