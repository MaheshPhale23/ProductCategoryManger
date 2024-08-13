package com.ms.service;

import org.springframework.data.domain.Page;

import com.ms.entity.Category;

public interface CategoryService {
	
	// create category
	public Category createCategory(Category category);
	
	// get all category
	public Page<Category> getAllCategories(int page);
	
	// get category by category id
	public Category getCategoryById(Long cat_id);
	
	// update category by id
	public Category updateCategory(Long cat_id, Category category);
	
	// delete category by id 
	public void deleteCategory(Long cat_id);

}
