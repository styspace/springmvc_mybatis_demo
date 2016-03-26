/**
 * Package name:com.styspace.utils
 * File name:MemcacheHepler.java
 * Date:2016年3月26日-下午5:13:13
 * styspace Copyright (c) 2013-2016 All Rights Reserved.
 *
 */
package com.styspace.utils;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

import javax.annotation.PostConstruct;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.styspace.controller.UserController;

import net.spy.memcached.MemcachedClient;

/**
 * memchached类
 * @ClassName MemcacheHepler
 * @Description 
 * @date 2016年3月26日 下午5:13:13
 * @author styspace
 * @version 1.0.0
 *
 */
@Component
public class MemcacheHepler {
	private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);
	
	public static final int DEFAULT_TIMEOUT = 5;// 读取memchache的时间
	
	public static final TimeUnit DEFAULT_TIMEUNIT = TimeUnit.SECONDS;// 读取memchache的时间单位数-秒
	
	@Value("${memcached.servers}")
	private String memcachedServers;
	
	private MemcachedClient client;
	
	/**
	 * 初始化 PostConstruct 类初始化之后执行
	 * init
	 * @throws IOException
	 *void
	 * @exception
	 * @since  1.0.0
	 */
	@PostConstruct
	public void init() throws IOException{
		if(StringUtils.isBlank(memcachedServers)){
			throw new RuntimeException("Memcached服务器地址和端口未配置");
		}
		// 服务器地址
		String[] serviceList = memcachedServers.split(",");
		// 客户端初始化参数(ip和端口号分开)
		List<InetSocketAddress> initParam = new ArrayList<InetSocketAddress>();
		String[] serverAndPort = null;
		for(String serviceTmp: serviceList){
			serverAndPort = serviceTmp.split(":");
			LOGGER.info("memcache ip:" + serverAndPort[0] + "--- port:" + serverAndPort[1]);
			InetSocketAddress address = new InetSocketAddress(serverAndPort[0], Integer.valueOf(serverAndPort[1]));
			initParam.add(address);
		}
		client = new MemcachedClient(initParam);
	}
	
	/**
	 * 将内容安装key值存储
	 * set
	 * @param key 键值
	 * @param data 内容
	 * @param expire 存储时间
	 * @return
	 *boolean
	 * @exception
	 * @since  1.0.0
	 */
	public boolean set(String key, Object data, int expire) {
		Future<Boolean> f = client.set(key, expire, data);
		return getBooleanValue(f);
	}
	
	/**
	 * 根据key值读取缓存
	 * get
	 * @param key 键值
	 * @return
	 *Object
	 * @exception
	 * @since  1.0.0
	 */
	public Object get(String key) {
		return client.get(key);
	}
	
	/**
	 * 根据key值删除缓存
	 * delete
	 * @param key
	 * @return
	 *boolean
	 * @exception
	 * @since  1.0.0
	 */
	public boolean delete(String key) {
		Future<Boolean> f = client.delete(key);
		return getBooleanValue(f);
	}
	
	/**
	 * 判断操作是否成功
	 * getBooleanValue
	 * @param f
	 * @return
	 *boolean
	 * @exception
	 * @since  1.0.0
	 */
	private boolean getBooleanValue(Future<Boolean> f) {
		try{
			Boolean bool = f.get(DEFAULT_TIMEOUT, DEFAULT_TIMEUNIT);
			return bool.booleanValue();
		} catch(Exception e) {
			f.cancel(false);
			return false;
		}
	}
}
