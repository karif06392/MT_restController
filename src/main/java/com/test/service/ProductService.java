package com.test.service;

import java.util.List;

import com.test.entities.Category;
import com.test.entities.Product;

public interface ProductService {

		public List<Product> getAllProducts();

		public Product addProduct(int cid, Product product);

		Product getSinleProduct(int pid);

		Product updateProduct(int pid, Product product);

		 void deleteProduct(int pid);

}
