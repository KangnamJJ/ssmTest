package com.spier.controller;

import java.util.HashSet;
import java.util.Set;

import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.JedisCluster;
import redis.clients.jedis.JedisPoolConfig;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Test {
	/*@Autowired
    StringRedisTemplate redisTemplate;
	*/
	@org.junit.Test
	public void test() {
		//Jedis jedis = new Jedis("192.168.184.130",6379);
		/*Jedis jedis = new Jedis("34.220.26.134",6666);
		jedis.set("name", "tiglle");
        //取出存入的数据
        String data = jedis.get("name");
        System.out.println(data);*/
        
        
		/*Set<HostAndPort> jedisClusterNodes = new HashSet<HostAndPort>();
		// Jedis Cluster will attempt to discover cluster nodes automatically
		jedisClusterNodes.add(new HostAndPort("34.220.26.134", 6379));
		jedisClusterNodes.add(new HostAndPort("34.220.26.134", 7379));
		jedisClusterNodes.add(new HostAndPort("34.220.26.134", 8379));
		jedisClusterNodes.add(new HostAndPort("34.220.26.134", 6380));
		jedisClusterNodes.add(new HostAndPort("34.220.26.134", 7380));
		jedisClusterNodes.add(new HostAndPort("34.220.26.134", 8380));
		JedisCluster jc = new JedisCluster(jedisClusterNodes);
        
		jc.set("foo", "bar");// 不设置超时
        String string = jc.get("foo");
        System.out.println(string);*/
	/*	GenericObjectPoolConfig poolConfig = new GenericObjectPoolConfig();
		JedisPool jedisPool = new JedisPool(poolConfig, "34.220.26.134", 6379);
		//向JedisPool借用8次连接，但是没有执行归还操作。
		    Jedis jedis = null;
		    	jedis = jedisPool.getResource();
		        //具体的命令
		
		*/
		
		/*JedisPoolConfig config = new JedisPoolConfig();
        config.setMaxTotal(64);
        config.setMaxIdle(20);
        config.setMaxWaitMillis(3000);
        config.setTestOnBorrow(true);
        config.setTestOnReturn(true);*/
		
		JedisPoolConfig config = new JedisPoolConfig();
		config = new JedisPoolConfig();
		config.setMaxTotal(2);// 设置最大连接数
		config.setMaxIdle(2); // 设置最大空闲数
		config.setMaxWaitMillis(3000);// 设置超时时间
		config.setTestOnBorrow(true);
        
        
		Set<HostAndPort> jedisClusterNode = new HashSet<HostAndPort>();
		jedisClusterNode.add(new HostAndPort("34.220.26.134", 6379));
		jedisClusterNode.add(new HostAndPort("34.220.26.134", 7379));
		jedisClusterNode.add(new HostAndPort("34.220.26.134", 8379));
		jedisClusterNode.add(new HostAndPort("34.220.26.134", 6380));
		jedisClusterNode.add(new HostAndPort("34.220.26.134", 7380));
		jedisClusterNode.add(new HostAndPort("34.220.26.134", 8380));
		JedisCluster jc = new JedisCluster(jedisClusterNode, 10,1000,config);
		//JedisCluster jc = new JedisCluster(jedisClusterNode, 10,10,1000, "1234567890",config);
		// JedisCluster jc = new JedisCluster(jedisClusterNode);
		jc.set("name2", "zhangsan");
		String value = jc.get("name");
		System.out.println(value);
		
		/*JedisPoolConfig config = new JedisPoolConfig();
		config = new JedisPoolConfig();
		config.setMaxTotal(2);// 设置最大连接数
		config.setMaxIdle(2); // 设置最大空闲数
		config.setMaxWaitMillis(3000);// 设置超时时间
		config.setTestOnBorrow(true);
		Set<HostAndPort> jedisClusterNode = new HashSet<HostAndPort>();
		jedisClusterNode.add(new HostAndPort("192.168.184.130", 6379));
		jedisClusterNode.add(new HostAndPort("192.168.184.130", 7379));
		jedisClusterNode.add(new HostAndPort("192.168.184.130", 8379));
		jedisClusterNode.add(new HostAndPort("192.168.184.130", 6380));
		jedisClusterNode.add(new HostAndPort("192.168.184.130", 7380));
		jedisClusterNode.add(new HostAndPort("192.168.184.130", 8380));

		JedisCluster jc = new JedisCluster(jedisClusterNode, 10,1000,config);
		// JedisCluster jc = new JedisCluster(jedisClusterNode);
		jc.set("name2", "zhangsan");
		String value = jc.get("name");
		System.out.println(value);*/
		
		
        /*JedisPoolConfig config = new JedisPoolConfig();
        config.setMaxTotal(10);
        config.setMaxIdle(2);
        HostAndPort node0 = new HostAndPort("34.220.26.134", 6379);
        HostAndPort node1 = new HostAndPort("34.220.26.134", 7379);	
        Set<HostAndPort> nodes = new HashSet<HostAndPort>();
        nodes.add(node0);
        nodes.add(node1);
        JedisCluster js2 = new JedisCluster(nodes);
        js2.set("foo2", "bar");
        String o = js2.get("foo");
        System.out.println(o);*/
	}
}
