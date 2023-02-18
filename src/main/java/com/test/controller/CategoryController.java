package com.test.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import com.test.entities.Category;
import com.test.service.CategoryService;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {

	private CategoryService categoryService;

	public CategoryController(CategoryService categoryService) {
		super();
		this.categoryService = categoryService;
	}

	
	@PostMapping
	public ResponseEntity<Category> createCategory(@RequestBody Category category) {
		try {
			Category c = this.categoryService.createCategory(category);

			System.out.println(category);
			return ResponseEntity.status(HttpStatus.CREATED).build();
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
	
	@GetMapping
	public ResponseEntity<List<Category>> getAllCategory() {
		
		List<Category> list = this.categoryService.getAllCategory();
		System.out.println(list);
		return ResponseEntity.status(HttpStatus.CREATED).body(list);
	}
	
	@GetMapping("/{cid}")
	public ResponseEntity<Category> getCategory(@PathVariable("cid") int cid){
		
		Category category = this.categoryService.getCategoryById(cid);
		
		return ResponseEntity.of(Optional.of(category));
	}
	
	@PutMapping("/{cid}")
	public ResponseEntity<Category> updateCategory(@PathVariable("cid") int cid,@RequestBody Category category){
		
		Category updateCategory = this.categoryService.updateCategory(cid,category);
		System.out.println("new updated"+updateCategory);
		
		return ResponseEntity.ok(updateCategory);
	}
	
	@DeleteMapping("/{cid}")
	public void deleteCategory(@PathVariable("cid") int cid){
		
		this.categoryService.deleteCategory(cid);
	}
 	
}
