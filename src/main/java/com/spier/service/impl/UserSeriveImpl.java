package com.spier.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spier.entity.User;
import com.spier.mapper.UserMapper;
import com.spier.service.UserService;

@Service
public class UserSeriveImpl  implements UserService{

	@Autowired
	private UserMapper userMapper;


	public List<User> queryUserByName(String name) {
		List<User> list = this.userMapper.queryUserByName(name);
		return list;
	}

}
