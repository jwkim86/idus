package com.jwkim.idus.service;



import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.jwkim.idus.dto.User;
import com.jwkim.idus.mapper.writeApi.WriteApiMapper;

@Service
public class CommonService {
	
	@Autowired
	WriteApiMapper mapper;
	
	public void insertUser(User user) {
		mapper.insertUser(user);
	}
}
