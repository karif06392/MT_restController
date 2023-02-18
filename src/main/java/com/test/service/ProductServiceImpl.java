package com.test.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.Repository.CategoryRepository;
import com.test.Repository.ProductRepository;
import com.test.entities.Category;
import com.test.entities.Product;

import jakarta.transaction.Transactional;

@Service
public class ProductServiceImpl implements ProductService{

	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	@Autowired
	
	@Override
	public List<Product> getAllProducts() {
		
		return this.productRepository.findAll();
	}

	@Override
	public Product addProduct(int cid, Product product) {
		
		Category category = this.categoryRepository.findById(cid);
		
		product.setCategory(category);
		
		return this.productRepository.save(product);
	}

	@Override
	public Product getSinleProduct(int pid) {
		
		return this.productRepository.findById(pid);
	}

	@Override
	public Product updateProduct(int pid, Product product) {
		
		return this.productRepository.save(product);
	}

	@Override
	public void deleteProduct(int pid) {
		
		this.productRepository.deleteById(pid);
	}

	

	
}
