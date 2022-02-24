package com.jwkim.idus.mapper.readApi;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.jwkim.idus.dto.Order;
import com.jwkim.idus.dto.User;

@Mapper
@Repository
public interface ReadApiMapper {

	Map<String,String> findUserPasswd(String id);
	
	User findUser(String id);
	List<Order> findUserOrderList(String id);
	List<User> findUserList(Map<String, Object> params);
}
