package com.tuanphamjava.converter;

import org.springframework.stereotype.Component;

import com.tuanphamjava.dto.NewsDTO;
import com.tuanphamjava.entity.NewsEntity;

@Component
public class NewsConverter {
	
	public NewsDTO toDto(NewsEntity entity) {
		NewsDTO result = new NewsDTO();
		result.setId(entity.getId());
		result.setTitle(entity.getTitle());
		result.setShortDescription(entity.getShortDescription());
		result.setContent(entity.getContent());
		result.setThumbnail(entity.getThumbnail());
		result.setCategoryCode(entity.getCategory().getCode());
		return result;
	}
	
	public NewsEntity toEntity(NewsDTO dto) {
		NewsEntity result = new NewsEntity();
		result.setTitle(dto.getTitle());
		result.setShortDescription(dto.getShortDescription());
		result.setContent(dto.getContent());
		result.setThumbnail(dto.getThumbnail());
		return result;
	}
	
	public NewsEntity toEntity(NewsEntity result, NewsDTO dto) {
		result.setTitle(dto.getTitle());
		result.setShortDescription(dto.getShortDescription());
		result.setContent(dto.getContent());
		result.setThumbnail(dto.getThumbnail());
		return result;
	}
	
	
}
