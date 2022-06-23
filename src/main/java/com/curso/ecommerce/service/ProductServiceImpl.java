package com.curso.ecommerce.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.curso.ecommerce.model.Product;
import com.curso.ecommerce.repository.ProductRepository;


@Service("productService")

public class ProductServiceImpl implements ProductService
 {

	
	@Autowired
	private ProductRepository productRepository;
	@Override
	public Product save(Product product) {
	
		return productRepository.save(product);

	}

}
