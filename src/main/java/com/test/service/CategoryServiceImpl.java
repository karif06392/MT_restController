package com.test.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.Repository.CategoryRepository;
import com.test.entities.Category;

@Service
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	private CategoryRepository categoryRepository;
	
	@Override
	public Category createCategory(Category category) {
		
		return this.categoryRepository.save(category);
	}

	@Override
	public List<Category> getAllCategory(Integer pageNumber, Integer pageSize) {
		
		Pageable p=PageRequest.of(pageNumber, pageSize);
		
		Page<Category> pagePost = this.categoryRepository.findAll(p);
		
		 List<Category> content = pagePost.getContent();
		
		 return content;
	}

	@Override
	public Category getCategoryById(int cid) {
		
		return this.categoryRepository.findById(cid);
	}


	@Override
	public Category updateCategory(int cid, Category category) {
		
		return this.categoryRepository.save(category);
	}

	@Override
	public void deleteCategory(int cid) {
		
	 this.categoryRepository.deleteById(cid);;
		
	}

}
