package com.spier.conf;

import java.util.HashSet;
import java.util.Set;

import org.apache.commons.pool2.impl.GenericObjectPoolConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.JedisCluster;
import redis.clients.jedis.JedisPoolConfig;

@Configuration
@EnableConfigurationProperties(ClusterRedisProperties.class)
public class MonitorConfig {
	
	private static final Logger LOGGER=LoggerFactory.getLogger(MonitorConfig.class);
	@Autowired
	private ClusterRedisProperties clusterRedisProperties;

	@Bean
	public JedisCluster getJedisCluster() {
		String[] serverArray = clusterRedisProperties.getNodes().split(",");
		Set<HostAndPort> nodes = new HashSet<>();

		for (String ipPort : serverArray) {
			String[] ipPortPair = ipPort.split(":");
			nodes.add(new HostAndPort(ipPortPair[0].trim(), Integer.valueOf(ipPortPair[1].trim())));
		}
		JedisPoolConfig jpoolConfig=new JedisPoolConfig();
		jpoolConfig.setMaxTotal(200);
		jpoolConfig.setMaxIdle(50);
		jpoolConfig.setMaxWaitMillis(15000L);
		jpoolConfig.setLifo(true);
		jpoolConfig.setBlockWhenExhausted(true);
		jpoolConfig.setTestOnBorrow(false);
		jpoolConfig.setTestOnReturn(false);
		jpoolConfig.setTestWhileIdle(true);
		jpoolConfig.setTimeBetweenEvictionRunsMillis(30000L);
		//JedisCluster jedisCluster = new JedisCluster(nodes, new GenericObjectPoolConfig());
		JedisCluster jedisCluster = new JedisCluster(nodes, 30000, jpoolConfig);
		return jedisCluster;
	}








/*


	@Bean
	public RedisClusterConfiguration getClusterConfiguration(){
		Map<String, Object> source = new HashMap<String, Object>();
		source.put("spring.redis.cluster.nodes", clusterRedisProperties.getNodes());
		source.put("spring.redis.cluster.timeout", 30000);
		source.put("spring.redis.cluster.max-redirects", 3);
		return new RedisClusterConfiguration(new MapPropertySource("RedisClusterConfiguration", source));
	}
	
	@Bean
	public JedisConnectionFactory getConnectionFactory() {
		JedisPoolConfig jpoolConfig=new JedisPoolConfig();
		jpoolConfig.setMaxTotal(200);
		jpoolConfig.setMaxIdle(50);
		jpoolConfig.setMaxWaitMillis(15000L);
		jpoolConfig.setLifo(true);
		jpoolConfig.setBlockWhenExhausted(true);
		jpoolConfig.setTestOnBorrow(false);
		jpoolConfig.setTestOnReturn(false);
		jpoolConfig.setTestWhileIdle(true);
		jpoolConfig.setTimeBetweenEvictionRunsMillis(30000L);
		return new JedisConnectionFactory(getClusterConfiguration(),jpoolConfig);
	}
	
	@Bean
	public JedisCluster getJedisCluster(JedisConnectionFactory jconnectionFactory) {
		JedisCluster jedisCluster = null;
		try {
			jedisCluster = new JedisCluster((HostAndPort) getClusterConfiguration().getClusterNodes());
		} catch (Exception e) {
			LOGGER.error("初始化jediscluster异常",e);
		}
		return jedisCluster;
	}
	@Bean(name="clusterConnection")
	public JedisClusterConnection getJedisClusterConnection(){
		return (JedisClusterConnection) getConnectionFactory().getConnection();
	}
	
	@Bean
	@SuppressWarnings({ "rawtypes", "unchecked"})
	public RedisTemplate getRedisTemplate() {
		RedisTemplate clusterTemplate = new RedisTemplate();
		clusterTemplate.setConnectionFactory(getConnectionFactory());
		clusterTemplate.setKeySerializer(new Jackson2JsonRedisSerializer(Object.class));
		clusterTemplate.setDefaultSerializer(new GenericJackson2JsonRedisSerializer());
		return clusterTemplate;
	}*/
	
}
