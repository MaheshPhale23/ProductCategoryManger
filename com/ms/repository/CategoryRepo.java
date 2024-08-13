package com.ms.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ms.entity.Category;

public interface CategoryRepo extends JpaRepository<Category, Long>{

}
