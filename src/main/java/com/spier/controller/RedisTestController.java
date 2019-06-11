package com.spier.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.spier.entity.User;
import com.spier.mapper.JedisClusterService;

import redis.clients.jedis.JedisCluster;
@RestController
public class RedisTestController<T> {
	
	private Logger logger = LoggerFactory.getLogger(RedisTestController.class);
	@Autowired
	private JedisCluster jedisCluster;
	@Autowired
	private JedisClusterService jedisService;
	
	
	@RequestMapping("/pushObject")
	public Object testRedisPush(){
     User  user =new User();
     user.setId(1L);
     user.setName("123123");
     user.setPassword("12321");
     jedisService.saveOrUpdate("1234", user);
     User value = jedisService.getValue("1234", User.class);
     //String set = jedisCluster.set("junjie", "123456");
	 logger.error("保存成功");
	 return "OK";
	}
	
	@RequestMapping("/pushList")
	public Object testRedisPush2(){
     List<String> list = new ArrayList<String>();
     list.add("你好");
     list.add("123");
    /* List<String> list2 =new  ArrayList<>();
     if(list2 !=null) { 
    	 System.out.println("不为null");
      }
     if(list2.size() < 0) { 
    	 System.out.println("小雨0");
      }
     list2 = jedisService.getValue("list2", List.class);*/
     jedisService.saveOrUpdate("list", list);
     System.out.println(list);
     System.out.println(list.toString());
     List value = jedisService.getValue("list", List.class);
     System.out.println(value.toString());
     //String set = jedisCluster.set("junjie", "123456");
	 logger.error("保存成功");
	 return "OK";
	}
	
	@RequestMapping("/pushObjectList")
	public Object testRedisPush3(){
		User  user =new User();
	     user.setId(1L);
	     user.setName("123123");
	     user.setPassword("12321");
	     User  user2 =new User();
	     user2.setId(2L);
	     user2.setName("你好");
	     user2.setPassword("你好");
     List<User> list = new ArrayList<User>();
     list.add(user);
     list.add(user2);
     jedisService.saveOrUpdate("listObject", list);
     String string = jedisService.get("listObject");
     List<User> value = JSON.parseObject(string,  new TypeReference<List<User>>(){});
     for (User user3 : value) {
    	 System.out.println(user3.getName());
    	 System.out.println(user3.getPassword());
    	 System.out.println("------------------");
	}
     //String set = jedisCluster.set("junjie", "123456");
	 logger.error("保存成功");
	 return "OK";
	}
	
	
	@RequestMapping("/push2")
	public Object testRedisPush2(String password){
		//redisTemplate.opsForValue().set("password", password);
	 return "OK";
	}
	
	
	@RequestMapping("/pop")
	 public Object testRedisPop(String password){
		// redisTemplate.opsForValue().get("password");
		return "" ; 	
	}
	
	

	
}
