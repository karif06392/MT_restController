package com.test.service;


import java.util.List;
import java.util.Optional;

import com.test.entities.Category;

public interface CategoryService  {

	Category createCategory(Category category);

	List<Category> getAllCategory();

	Category getCategoryById(int cid);

	Category updateCategory(int cid, Category category);

	void deleteCategory(int cid);

}
