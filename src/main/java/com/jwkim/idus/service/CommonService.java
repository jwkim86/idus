package com.jwkim.idus.service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.jwkim.idus.dto.User;
import com.jwkim.idus.mapper.writeApi.WriteApiMapper;

@Service
public class CommonService {
	
	@Autowired
	WriteApiMapper mapper;
	
	public void insertUser(User user) {
		
		// 매번 다른 스트링 생성
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
				
		// 패스워드 암호화
		String cipherText =  encoder.encode(user.getPasswd());
		user.setPasswd(cipherText);
		
		mapper.insertUser(user);
	}
}
