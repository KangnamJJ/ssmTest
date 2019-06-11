package com.spier.conf;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
//@Component
@ConfigurationProperties(prefix = "redis.cluster")
public class ClusterRedisProperties {
	private int maxTotal; // 最大连接数
	private int maxIdle; // 最大空闲数
	private int minIdle;// 初始化连接数
	private long maxWait; // 建立连接时最大等待时间，单位毫秒
	private int timeout;// 客户端超时时间，单位毫秒
	private boolean testOnBorrow; // 指明是否在从池中取出连接前进行检验,如果检验失败,则从池中去除连接并尝试取出另一个
	private boolean testOnReturn;// 在return给pool时，是否提前进行validate操作
	// 如果为true，表示有一个idle object evitor线程对idle
	// object进行扫描，如果validate失败，此object会被从pool中drop掉；
	private boolean testWhileIdle;
	// 配合testWhileIdle使用，表示idle object evitor两次扫描之间要sleep的毫秒数
	private long timeBetweenEvictionRunsMillis;
	private String nodes;
	private int maxRedirects;
	
	public int getMaxTotal() {
		return maxTotal;
	}
	public void setMaxTotal(int maxTotal) {
		this.maxTotal = maxTotal;
	}
	public int getMaxIdle() {
		return maxIdle;
	}
	public void setMaxIdle(int maxIdle) {
		this.maxIdle = maxIdle;
	}
	public int getMinIdle() {
		return minIdle;
	}
	public void setMinIdle(int minIdle) {
		this.minIdle = minIdle;
	}
	public long getMaxWait() {
		return maxWait;
	}
	public void setMaxWait(long maxWait) {
		this.maxWait = maxWait;
	}
	public int getTimeout() {
		return timeout;
	}
	public void setTimeout(int timeout) {
		this.timeout = timeout;
	}
	public boolean isTestOnBorrow() {
		return testOnBorrow;
	}
	public void setTestOnBorrow(boolean testOnBorrow) {
		this.testOnBorrow = testOnBorrow;
	}
	public boolean isTestOnReturn() {
		return testOnReturn;
	}
	public void setTestOnReturn(boolean testOnReturn) {
		this.testOnReturn = testOnReturn;
	}
	public boolean isTestWhileIdle() {
		return testWhileIdle;
	}
	public void setTestWhileIdle(boolean testWhileIdle) {
		this.testWhileIdle = testWhileIdle;
	}
	public long getTimeBetweenEvictionRunsMillis() {
		return timeBetweenEvictionRunsMillis;
	}
	public void setTimeBetweenEvictionRunsMillis(long timeBetweenEvictionRunsMillis) {
		this.timeBetweenEvictionRunsMillis = timeBetweenEvictionRunsMillis;
	}
	public String getNodes() {
		return nodes;
	}
	public void setNodes(String nodes) {
		this.nodes = nodes;
	}
	public int getMaxRedirects() {
		return maxRedirects;
	}
	public void setMaxRedirects(int maxRedirects) {
		this.maxRedirects = maxRedirects;
	}
}
