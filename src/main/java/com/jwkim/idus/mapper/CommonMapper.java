package com.jwkim.idus.mapper;

import java.util.List;
import java.util.Map;

import com.jwkim.idus.dao.Order;
import com.jwkim.idus.dao.User;

public interface CommonMapper {

	void insertUser(User user);
	User findUser(String id);
	List<Order> findUserOrderList(String id);
	List<User> findUserList(Map<String, Object> params);
}
