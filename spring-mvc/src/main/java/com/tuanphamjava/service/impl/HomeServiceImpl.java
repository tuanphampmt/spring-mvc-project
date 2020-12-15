package com.tuanphamjava.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.tuanphamjava.service.HomeService;

@Service
public class HomeServiceImpl implements HomeService {

	
	@Override
	public List<String> loadMenu() {
		List<String> menus = new ArrayList<String>();

		menus.add("Blog java");
		menus.add("Hướng dẫn học java web");
		menus.add("Liên hệ");
		menus.add("Thanh toán");
		return menus;
	}

}
