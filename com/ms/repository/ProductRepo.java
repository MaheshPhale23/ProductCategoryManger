package com.ms.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ms.entity.Product;

public interface ProductRepo extends JpaRepository<Product, Long>{

}
