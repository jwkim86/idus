package com.jwkim.idus;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jwkim.idus.dto.Order;
import com.jwkim.idus.dto.User;
import com.jwkim.idus.mapper.readApi.ReadApiMapper;
import com.jwkim.idus.service.CommonService;

@RestController
public class RootController {
	
	
	@Autowired
	CommonService service;

	@Autowired
	ReadApiMapper mapper;
	
	
	@GetMapping("/")
	public String baseDir() {
		
		
		return "Hello idus!!";
    }
		
	// 회원 가입
	@PostMapping("/user/{id}")
	public boolean insertUser(HttpServletRequest request, @PathVariable String id, @RequestParam User user) {
		
		user.setUser_id(id);		
		service.insertUser(user);		
		return true;
    }
	
	// 회원 조회 
	@GetMapping("/user/{id}")
	public User findUser(@PathVariable String id) {
		return mapper.findUser(id);
	}
	
	// 회원 주문 조회
	@GetMapping("/user/{id}/order")
	public List<Order> findUserOrderList(@PathVariable String id) {
		return mapper.findUserOrderList(id);
	}
	
	// 회원 목록 조회
	@GetMapping("/user")
	public List<User> findUserList(@RequestParam Map<String, Object> params) {
		return mapper.findUserList(params);
	}
}
