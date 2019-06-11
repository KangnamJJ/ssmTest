package com.spier.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;

import redis.clients.jedis.JedisCluster;

@Service
public  class JedisClusterServiceImpl implements JedisClusterService{
	private int timeOut = 3600;//默认超时时间
	
	@Autowired
	private JedisCluster jedisCluster;
	
	@Override
	public void set(String key, String value) {
		jedisCluster.setex(key,this.timeOut,value);
	}
	
	public void saveOrUpdate(String key, int timeout, String value) {
		jedisCluster.setex(key, timeout, value);
	}

	@Override
	public Long expire(String key, int timeout) {
		return jedisCluster.expire(key, timeout);
	}

	@Override
	public String get(String key) {
		return jedisCluster.get(key);
	}

	@Override
	public Long del(String key) {
		return jedisCluster.del(key);
	}

	@Override
	public Long incr(String key) {
		return jedisCluster.incr(key);
	}
	@Override
	public void saveOrUpdate(String key, Object obj) {
		jedisCluster.setex(key, this.timeOut, JSON.toJSONString(obj));
	}
	@Override
	public void saveOrUpdate(String key, int timeout, Object obj) {
		jedisCluster.setex(key, timeout, JSON.toJSONString(obj));
	}

	@Override
	public long lpush(String key, String value) {
	   return this.jedisCluster.lpush(key, new String[]{value});
	}
	public <T> T getValue(String key ,Class<T> clazz){
		return (T) JSON.parseObject(get(key), clazz);
	}
}
