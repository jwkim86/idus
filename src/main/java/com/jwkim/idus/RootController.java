package com.jwkim.idus;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jwkim.idus.dao.Order;
import com.jwkim.idus.dao.User;
import com.jwkim.idus.mapper.CommonMapper;
import com.jwkim.idus.service.CommonService;

@RestController
public class RootController {
	
	
	@Autowired
	CommonService service;

	@Autowired
	CommonMapper mapper;
		
	// 회원 가입
	@PostMapping("/user")
	public boolean insertUser(HttpServletRequest request, @RequestParam User user) {
		
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
