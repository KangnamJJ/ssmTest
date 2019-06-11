package com.spier.mapper;

import java.util.List;

import com.alibaba.fastjson.TypeReference;
import com.spier.entity.User;

public interface JedisClusterService {
	// 设置
	public void set(String key, String value);

	// 设置并同时设置过期时间
	public void saveOrUpdate(String key, int timeout, String value);
	
	public void saveOrUpdate(String key,Object obj);
	
	public void saveOrUpdate(String key, int timeout, Object obj);
	
	// 获取key值
    public String get(String key);
    
	// 设置key过期
	public Long expire(String key, int timeout);

	// 删除key
	public Long del(String key);

	// 自增
	public Long incr(String key);

    public long lpush(String key, String value);
    
    public <T> T getValue(String key ,Class<T> clazz);

}
