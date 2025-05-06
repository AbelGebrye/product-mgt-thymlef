package com.springboot.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.demo.dao.ProductRepository;
import com.springboot.demo.entity.Product;

@Service
public class ProductServiceImpl implements ProductService {

	
	@Autowired
	private ProductRepository productRepository;
	

	
	@Override
	public List<Product> findAll() {
		return productRepository.findAll();
	}

	@Override
	public Product findById(int theId) {
		Optional<Product> result = productRepository.findById(theId);
		
		Product product = null;
		
		if (result.isPresent()) {
			product = result.get();
		}
		else {
			// we didn't find the product
			throw new RuntimeException("Did not find product id - " + theId);
		}
		
		return product;
	}

	@Override
	public void save(Product product) {
		productRepository.save(product);
	}

	@Override
	public void deleteById(int theId) {
		productRepository.deleteById(theId);
	}

}






