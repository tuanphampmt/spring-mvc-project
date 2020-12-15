package com.tuanphamjava.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tuanphamjava.entity.CategoryEntity;

public interface CategoryRepository extends JpaRepository<CategoryEntity, Long> {
	
	CategoryEntity findOneByCode(String code); 	
	
	
}
