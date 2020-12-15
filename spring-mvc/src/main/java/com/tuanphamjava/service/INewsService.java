package com.tuanphamjava.service;

import java.util.List;

import org.springframework.data.domain.Pageable;

import com.tuanphamjava.dto.NewsDTO;

public interface INewsService {

	List<NewsDTO> findAll(Pageable pageable);
	int getTotalItem();
	NewsDTO findById(long id);
	NewsDTO insert(NewsDTO dto);
	NewsDTO update(NewsDTO upNewsDTO);
}
