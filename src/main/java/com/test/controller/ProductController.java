package com.test.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.test.entities.Category;
import com.test.entities.Product;
import com.test.service.ProductService;

@RestController
@RequestMapping("/api/products")
public class ProductController {

	private ProductService productService;

	
	public ProductController(ProductService productService) {
		super();
		this.productService = productService;
	}
	
	@GetMapping
	public ResponseEntity<List<Product>> getProducts() {
		
		List<Product> products = this.productService.getAllProducts();
		return ResponseEntity.status(HttpStatus.CREATED).body(products);
	}
	
	@PostMapping("/{cid}")
	public ResponseEntity<Product> addProductByCid(@PathVariable("cid") int cid,@RequestBody Product product){
		
		this.productService.addProduct(cid,product);
		
		return ResponseEntity.status(HttpStatus.CREATED).build();
	}
	
	@GetMapping("/{pid}")
	public ResponseEntity<Product> getSingleProduct(@PathVariable("pid") int pid){
		
		Product product = this.productService.getSinleProduct(pid);
		
		return ResponseEntity.of(Optional.of(product));
	}
	
	@PutMapping("/{pid}")
	public ResponseEntity<Product> updateProduct(@PathVariable("pid") int pid,@RequestBody Product product){
		
		Product product1 = this.productService.updateProduct(pid,product);
		return ResponseEntity.ok(product1);
	}
	
	@DeleteMapping("/{pid}")
	public void deleteProduct(@PathVariable("pid") int pid) {
		
		this.productService.deleteProduct(pid);
		
	}
}
