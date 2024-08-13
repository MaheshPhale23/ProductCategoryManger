package com.ms.service;

import org.springframework.data.domain.Page;

import com.ms.entity.Product;

public interface ProductService {
	
	// create product
	public Product createProduct(Product product);
	
	// get all product
	public Page<Product> getAllProducts(int page);
	
	// get product by product id
	public Product getProductById(Long pro_id);
	
	// update product by id
	public Product updateProduct(Long pro_id, Product product);
	
	// delete product by id
	public void deleteProduct(Long pro_id);

}
