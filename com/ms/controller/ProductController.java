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

import com.ms.entity.Product;
import com.ms.service.ProductService;

@RestController
@RequestMapping("/api/products")
public class ProductController {
	
	@Autowired
	ProductService productService;
	
	@PostMapping
	public Product createProduct(@RequestBody Product product) {
		return productService.createProduct(product);
	}
	
	@GetMapping
	public Page<Product> getAllProducts(@RequestParam int page){
		return productService.getAllProducts(page);
	}
	
	@GetMapping("/{pro_id}")
	public Product getProductById(@PathVariable Long pro_id) {
		return productService.getProductById(pro_id);
	}
	
	@PutMapping("/{pro_id}")
	public Product updateProduct(@PathVariable Long pro_id, @RequestBody Product product) {
		return productService.updateProduct(pro_id, product);
	}
	
	@DeleteMapping("{pro_id}")
	public void deleteProduct(@PathVariable Long pro_id) {
		productService.deleteProduct(pro_id);
	}
}
