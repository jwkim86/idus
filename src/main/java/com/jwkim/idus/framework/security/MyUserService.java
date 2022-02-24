package com.jwkim.idus.framework.security;
import java.util.Map;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.jwkim.idus.mapper.readApi.ReadApiMapper;

@Service
public class MyUserService implements UserDetailsService {


	@Autowired
	ReadApiMapper mapper;

	@Override
	public UserDetails loadUserByUsername(final String username) throws UsernameNotFoundException {



		// 회원 정보를 DB에서 조회.
		Map<String, String> userInfo = mapper.findUserPasswd(username);
		
		if(userInfo == null) {
			throw new UsernameNotFoundException("User "+ username +" not found.");
		}

		MyUserDetails user = new MyUserDetails();
		user.setUsername(userInfo.get("user_id"));
		user.setPassword(userInfo.get("passwd"));

		return user;
	}


}
