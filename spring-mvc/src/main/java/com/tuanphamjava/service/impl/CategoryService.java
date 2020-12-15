package com.tuanphamjava.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tuanphamjava.converter.CategoryConverter;
import com.tuanphamjava.entity.CategoryEntity;
import com.tuanphamjava.repository.CategoryRepository;
import com.tuanphamjava.service.ICategoryService;

@Service
public class CategoryService implements ICategoryService{
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	@Autowired
	private CategoryConverter categoryConverter;
	
	
	@Override
	public Map<String, String> findAll() {
		// TODO Auto-generated method stub
		Map<String, String> result = new HashMap<>();
		List<CategoryEntity> entities = categoryRepository.findAll();
		for (CategoryEntity item: entities) {
			result.put(item.getCode(), item.getName());
		}
		return result;
	}

}
