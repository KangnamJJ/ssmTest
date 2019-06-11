package com.spier.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.spier.entity.User;

@Mapper
public interface UserMapper {

	@Select("select * from user where name like '%${value}%'")
	public List<User> queryUserByName(String name);

}
