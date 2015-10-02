package com.rakuten.productMgmt.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rakuten.productMgmt.entities.Product;
import com.rakuten.productMgmt.repositories.ProductRepository;

@Service
@Transactional
public class ProductService{
	
	@Autowired
	private ProductRepository productRepository;

	public List<Product> findAll() {
		return productRepository.findAll();
	}

	public Product create(Product product) {
		return productRepository.save(product);
	}

	public Product findById(long id) {
		return productRepository.findOne(id);
	}

	public Product update(Product product) {
		return productRepository.save(product);
	}

	public void deleteProduct(long id) {
		productRepository.delete(id);
	}

}
