package com.tuanphamjava.api.admin;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.tuanphamjava.dto.NewsDTO;

@RestController(value = "newsAPIOfAdmin")
public class NewsAPI {

	
	@PostMapping("/api/v1/news")
	public NewsDTO createNews(@RequestBody NewsDTO newsDTO) {
		System.out.println(newsDTO);
		return newsDTO;	
	}
	
	@PutMapping("api/v1/news")
	public NewsDTO updateNewsDTO(@RequestBody NewsDTO newsDTO) {
		System.out.println(newsDTO.getTitle());

		return newsDTO;
	}
	
	@DeleteMapping("api/v1/news")
	public void deleteNews(@RequestBody long[] ids) {
		
	}
}
