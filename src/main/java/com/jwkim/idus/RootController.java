package com.jwkim.idus;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jwkim.idus.dto.Order;
import com.jwkim.idus.dto.User;
import com.jwkim.idus.mapper.readApi.ReadApiMapper;
import com.jwkim.idus.service.CommonService;

import io.swagger.annotations.ApiOperation;

@RestController
public class RootController {
	
	
	@Autowired
	CommonService service;

	@Autowired
	ReadApiMapper mapper;

	static int PAGE_SIZE = 10;
	
	
//	@GetMapping("/")
//	public String baseDir() {
//		
//		
//		return "Hello idus!!";
//    }
		
	
	@ApiOperation(value="회원 가입")
	@PostMapping("/user/{id}")
	public boolean insertUser(HttpServletRequest request, @PathVariable String id, @RequestBody User user) {
		
		user.setUser_id(id);		
		service.insertUser(user);		
		return true;
    }
	
	@ApiOperation(value="단일 회원 상세 정보 조회")
	@GetMapping("/user/{id}")
	public User findUser(@PathVariable String id) {
		return mapper.findUser(id);
	}
	
	@ApiOperation(value="단일 회원의 주문 목록 조회")
	@GetMapping("/user/{id}/order")
	public List<Order> findUserOrderList(@PathVariable String id) {
		return mapper.findUserOrderList(id);
	}
		
	@ApiOperation(value="여러 회원 목록 조회", notes=
			"\t- 페이지네이션으로 10건 단위로 조회합니다.\r\n" + 
			"\t- 이름, 이메일을 이용하여 검색이 가능합니다.\r\n" + 
			"\t- 각 회원의 마지막 주문 정보를 포함합니다.")
	@GetMapping("/user")
	public List<User> findUserList(@RequestParam Map<String, Object> params) {
		
		// 페이징 파라메터 설정
		Object page  = params.get("page");
		if(page !=null && Integer.valueOf(String.valueOf(page)) >= 1) {
			params.put("start", (Integer.valueOf(String.valueOf(page))-1) * 10);
		} else {
			params.put("start", 0);
		};
		params.put("page_size", PAGE_SIZE);
		
		
		return mapper.findUserList(params);
	}
}
