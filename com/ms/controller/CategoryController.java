package com.ms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ms.entity.Category;
import com.ms.service.CategoryService;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {
	
	@Autowired
	CategoryService categoryService;

	@PostMapping
	public Category createCategory(@RequestBody Category category) {
		return categoryService.createCategory(category);
	}
	
	@GetMapping
	public Page<Category> getAllCategories(@RequestParam int page){
		return categoryService.getAllCategories(page);
	}
	
	@GetMapping("/{cat_id}")
	public Category getCategoryById(@PathVariable Long cat_id) {
		return categoryService.getCategoryById(cat_id);
	}
	
	@PutMapping("/{cat_id}")
	public Category updateCategory(@PathVariable Long cat_id, @RequestBody Category category){
		return categoryService.updateCategory(cat_id, category);
	}
	
	@DeleteMapping("/{cat_id}")
	public void deleteCategory(@PathVariable Long cat_id) {
		categoryService.deleteCategory(cat_id);
	}
}
