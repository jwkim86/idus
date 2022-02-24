package com.jwkim.idus.mapper.writeApi;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.jwkim.idus.dto.User;

@Mapper
@Repository
public interface WriteApiMapper {

	
	void insertUser(User user);
}
