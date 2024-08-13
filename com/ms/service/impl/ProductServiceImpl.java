package com.ms.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.ms.entity.Product;
import com.ms.repository.ProductRepo;
import com.ms.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService{
	
	@Autowired
	ProductRepo productRepo;

	@Override
	public Product createProduct(Product product) {
		
		return productRepo.save(product);
	}

	@Override
	public Page<Product> getAllProducts(int page) {
		
		return productRepo.findAll(PageRequest.of(page, 2));
	}

	@Override
	public Product getProductById(Long pro_id) {
		
		return productRepo.findById(pro_id).get();
	}

	@Override
	public Product updateProduct(Long pro_id, Product product) {
		Optional<Product> products = productRepo.findById(pro_id);
		
		if(products.isPresent()) {
			Product existsId = products.get();
			existsId.setPro_name(product.getPro_name());
			existsId.setPrice(product.getPrice());
			existsId.setCategory(product.getCategory());
			return productRepo.save(existsId);
		}
		else {
			return null;
		}
		
		
	}

	@Override
	public void deleteProduct(Long pro_id) {
		
		productRepo.deleteById(pro_id);
		
	}

}
