/**
 * Package name:com.styspace.dao
 * File name:UserDao.java
 * Date:2016年3月25日-下午5:17:47
 * styspace Copyright (c) 2013-2016 All Rights Reserved.
 *
 */
package com.styspace.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.styspace.mapper.UserMapper;
import com.styspace.pojo.User;

/**
 * 用户dao
 * @ClassName UserDao
 * @Description 
 * @date 2016年3月25日 下午5:17:47
 * @author styspace
 * @version 1.0.0
 *
 */
@Repository
public class UserDao {
	@Autowired
	private UserMapper userMapper;
	
	public boolean register(User user) {
		return userMapper.insertUser(user);
	}
}
