package com.tuanphamjava.service.impl;

import com.tuanphamjava.converter.NewsConverter;
import com.tuanphamjava.dto.NewsDTO;
import com.tuanphamjava.entity.CategoryEntity;
import com.tuanphamjava.entity.NewsEntity;
import com.tuanphamjava.repository.CategoryRepository;
import com.tuanphamjava.repository.NewsRepository;
import com.tuanphamjava.service.INewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class NewsService implements INewsService {

	@Autowired
	private NewsRepository newsRepository;

	@Autowired
	private NewsConverter newsConverter;

	@Autowired
	private CategoryRepository categoryRepository;

	@Override
	public List<NewsDTO> findAll(Pageable pageable) {
		List<NewsDTO> models = new ArrayList<>();
		List<NewsEntity> entities = newsRepository.findAll(pageable).getContent();
		for (NewsEntity item : entities) {
			NewsDTO newsDTO = newsConverter.toDto(item);
			models.add(newsDTO);
		}
		return models;
	}

	@Override
	public int getTotalItem() {
		return (int) newsRepository.count();
	}

	@Override
	public NewsDTO findById(long id) {
		NewsEntity entity = newsRepository.findOne(id);
		return newsConverter.toDto(entity);
	}

	@Override
	@Transactional
	public NewsDTO insert(NewsDTO newsDTO) {
		CategoryEntity category = categoryRepository.findOneByCode(newsDTO.getCategoryCode());
		NewsEntity newsEntity = newsConverter.toEntity(newsDTO);
		newsEntity.setCategory(category);
		return newsConverter.toDto(newsRepository.save(newsEntity));
	}

	@Override
	@Transactional
	public NewsDTO update(NewsDTO upNewsDTO) {
		NewsEntity oldNewsEntity = newsRepository.findOne(upNewsDTO.getId());
		oldNewsEntity.setCategory(categoryRepository.findOneByCode(upNewsDTO.getCategoryCode()));
	
		return null;
	}
}
