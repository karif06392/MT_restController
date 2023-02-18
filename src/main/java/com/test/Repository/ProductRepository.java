package com.test.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.test.entities.Product;

public interface ProductRepository extends JpaRepository<Product,Integer> {
	
	public Product findById(int pid);

}
