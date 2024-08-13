package com.ms.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.ms.entity.Category;
import com.ms.repository.CategoryRepo;
import com.ms.service.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService{
	
	@Autowired
	CategoryRepo categoryRepo;

	@Override
	public Category createCategory(Category category) {
		
		return categoryRepo.save(category);
	}

	@Override
	public Page<Category> getAllCategories(int page) {
		
		return categoryRepo.findAll(PageRequest.of(page, 2));
	}

	@Override
	public Category getCategoryById(Long cat_id) {
		
		return categoryRepo.findById(cat_id).get();
	}

	@Override
	public Category updateCategory(Long cat_id, Category category) {
		
		Optional<Category> categories = categoryRepo.findById(cat_id);
		
		if(categories.isPresent()) {
			Category existsId = categories.get();
			existsId.setCat_name(category.getCat_name());
			
			return categoryRepo.save(existsId);
		}
		else {
			return null;
		}
		
	}

	@Override
	public void deleteCategory(Long cat_id) {
		
		categoryRepo.deleteById(cat_id);
	}

}
