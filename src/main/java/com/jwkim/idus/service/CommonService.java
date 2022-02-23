package com.jwkim.idus.service;



import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Component;

import com.jwkim.idus.dao.Order;
import com.jwkim.idus.dao.User;
import com.jwkim.idus.mapper.CommonMapper;

@Component
public class CommonService {
	
	@Autowired
	CommonMapper mapper;
	
	public void insertUser(User user) {
		mapper.insertUser(user);
	}
}
