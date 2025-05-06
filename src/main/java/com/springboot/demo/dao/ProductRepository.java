package com.springboot.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.demo.entity.Product;

//@RepositoryRestResource(path="members")
public interface ProductRepository extends JpaRepository<Product, Integer> {

	// that's its
	
	// add method to sort by last name
	public List<Product> findAll();
}
