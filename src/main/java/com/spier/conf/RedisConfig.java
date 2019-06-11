/*package com.spier.conf;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.MapPropertySource;
import org.springframework.data.redis.connection.RedisClusterConfiguration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.stereotype.Component;

import redis.clients.jedis.JedisCluster;
import redis.clients.jedis.JedisPoolConfig;

@Component
@Configuration
@EnableConfigurationProperties(ClusterRedisProperties.class)
public class RedisConfig {
	private static final String REDIS_CLUSTER_NODES_CONFIG_PROPERTY = "spring.redis.cluster.nodes";
	private static final String REDIS_CLUSTER_MAX_REDIRECTS_CONFIG_PROPERTY = "spring.redis.cluster.max-redirects";

	@Autowired
	private ClusterRedisProperties clusterRedisProperties;

	@Bean
    public JedisPoolConfig jedisPoolConfig(){
		  JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
		  jedisPoolConfig.setMaxTotal(clusterRedisProperties.getMaxTotal());
		  jedisPoolConfig.setMaxIdle(clusterRedisProperties.getMaxIdle());
		  jedisPoolConfig.setMinIdle(clusterRedisProperties.getMinIdle());
		  jedisPoolConfig.setMaxWaitMillis(clusterRedisProperties.getMaxWait());
		  jedisPoolConfig.setTestOnBorrow(clusterRedisProperties.isTestOnBorrow());
		  jedisPoolConfig.setTestOnReturn(clusterRedisProperties.isTestOnReturn());
		  jedisPoolConfig.setTestWhileIdle(clusterRedisProperties.isTestWhileIdle());
		  jedisPoolConfig.setTimeBetweenEvictionRunsMillis(clusterRedisProperties.getTimeBetweenEvictionRunsMillis());
	      return jedisPoolConfig;
	}

	*//**
     * redis集群配置
     * @return
     *//*
	@Bean
	public RedisClusterConfiguration redisClusterConfiguration(){
	 Map<String,Object> clusterPropertie = new HashMap<String, Object>();
	 clusterPropertie.put(REDIS_CLUSTER_NODES_CONFIG_PROPERTY, clusterRedisProperties.getNodes());
	 clusterPropertie.put(REDIS_CLUSTER_MAX_REDIRECTS_CONFIG_PROPERTY, clusterRedisProperties.getMaxRedirects());
	 MapPropertySource mapPropertySource = new MapPropertySource("RedisClusterConfiguration", clusterPropertie);
	
	 RedisClusterConfiguration redisClusterConfiguration = new RedisClusterConfiguration(mapPropertySource);
	 return redisClusterConfiguration;
	}
	
	*//**
     * 配置jedis连接工厂
     * @param redisClusterConfiguration
     * @param jedisPoolConfig
     * @return
     *//*
	@Bean
    public JedisConnectionFactory jedisConnectionFactory(RedisClusterConfiguration redisClusterConfiguration, JedisPoolConfig jedisPoolConfig){
		JedisConnectionFactory jedisConnectionFactory = new JedisConnectionFactory(redisClusterConfiguration,jedisPoolConfig);
		jedisConnectionFactory.setTimeout(clusterRedisProperties.getTimeout());
		return jedisConnectionFactory;
    }

    *//**
     * 配置RedisTemplate
     * @param factory
     * @return
     *//*
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Bean
	public RedisTemplate redisTemplate(JedisConnectionFactory factory){
		 RedisTemplate redisTemplate = new RedisTemplate();
		 Jackson2JsonRedisSerializer jackson2JsonRedisSerializer = new Jackson2JsonRedisSerializer(Object.class);
		 redisTemplate.setConnectionFactory(factory);
		 redisTemplate.setKeySerializer(jackson2JsonRedisSerializer);
		 redisTemplate.setValueSerializer(jackson2JsonRedisSerializer);
		 redisTemplate.setHashKeySerializer(jackson2JsonRedisSerializer);
		 redisTemplate.setHashValueSerializer(jackson2JsonRedisSerializer);
		 return redisTemplate;
   }
}
*/