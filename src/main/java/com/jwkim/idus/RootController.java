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
import org.springframework.web.servlet.ModelAndView;

import com.jwkim.idus.dto.Order;
import com.jwkim.idus.dto.User;
import com.jwkim.idus.mapper.readApi.ReadApiMapper;
import com.jwkim.idus.service.CommonService;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

@RestController
public class RootController {
	
	
	@Autowired
	CommonService service;

	@Autowired
	ReadApiMapper mapper;

	static int PAGE_SIZE = 10;
	
	@ApiOperation(
			value="swagger-ui 페이지",
			notes="swagger-ui 페이지로 리다이렉션 합니다.")
	@GetMapping("/")
	public ModelAndView baseDir() {		
		
		return new ModelAndView("redirect:/swagger-ui.html");
    }
		
	
	@ApiOperation(
			value="회원 가입",
			notes=
			"- 경로 변수로 주어진 사용자를 추가(회원 가입)합니다.\r\n" +
			"- 사용자 정보는 request body에 json 형태로 담아야 합니다.")
	@PostMapping("/user/{id}")
	public boolean insertUser(HttpServletRequest request, @PathVariable String id, @RequestBody User user) {
		
		user.setUser_id(id);		
		service.insertUser(user);		
		return true;
    }
	
	@ApiOperation(
			value="단일 회원 상세 정보 조회",
			notes="경로 변수로 주어진 사용자 정보를 조회합니다.")
	@GetMapping("/user/{id}")
	public User findUser(@PathVariable String id) {
		return mapper.findUser(id);
	}
	
	@ApiOperation(
			value="단일 회원의 주문 목록 조회",
			notes="경로 변수로 주어진 사용자의 모든 주문 정보를 조회합니다.")
	public List<Order> findUserOrderList(@PathVariable String id) {
		return mapper.findUserOrderList(id);
	}
		
	@ApiOperation(
			value="여러 회원 목록 조회",
			notes=
			"\t- 주어진 페이지에 해당하는 데이터를 10건 단위로 조회합니다.\r\n" + 
			"\t- 이름, 이메일을 이용하여 like 검색이 가능합니다.\r\n" + 
			"\t- 각 회원의 마지막 주문 번호를 포함합니다.\r\n" +
			"\tex. http://localhost:8080/user?page=1&user_name=테스트&email_addr=idus.com"
			)
	@ApiImplicitParams(
			{
				@ApiImplicitParam(
				        name = "page",
				        value = "페이지",
				        required = false,
				        dataType = "int",
				        paramType = "query",
				        defaultValue = "None"),
				@ApiImplicitParam(
				        name = "user_name",
				        value = "사용자명",
				        required = false,
				        dataType = "string",
				        paramType = "query",
				        defaultValue = "None"),
				@ApiImplicitParam(
				        name = "email_addr",
				        value = "이메일",
				        required = false,
				        dataType = "string",
				        paramType = "query",
				        defaultValue = "None"),
			}
			)
	
	@GetMapping("/user")
	public List<User> findUserList(@RequestParam Map<String, Object> params) {
		
		// 페이징 파라메터 설정
		try {
			int page = Integer.valueOf((String)params.get("page"));
			if(page >= 1) {
				params.put("start", (page-1) * PAGE_SIZE);
			} else {
				params.put("start", 0);
			};
		} catch (Exception e){
			params.put("start", 0);
		}
		
		// 페이지 크기 설정
		params.put("page_size", PAGE_SIZE);		
		
		return mapper.findUserList(params);
	}
}
