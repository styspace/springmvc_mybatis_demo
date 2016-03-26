/**
 * Package name:com.styspace.service.impls
 * File name:UserServiceImpl.java
 * Date:2016年3月24日-下午1:48:52
 * styspace Copyright (c) 2013-2016 All Rights Reserved.
 *
 */
package com.styspace.service.impls;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.styspace.dao.UserDao;
import com.styspace.pojo.User;
import com.styspace.service.interfaces.UserService;
import com.styspace.utils.MemcacheHepler;


/**
 * @ClassName UserServiceImpl
 * @Description 
 * @date 2016年3月24日 下午1:48:52
 * @author styspace
 * @version 1.0.0
 *
 */
@Service
public class UserServiceImpl extends BaseServiceImpl implements UserService {
	@Autowired
	private UserDao userDao;
	@Autowired
	private MemcacheHepler memcacheHepler;

	/* (non-Javadoc)
	 * @see com.styspace.service.interfaces.UserService#insertUser(com.styspace.pojo.User)
	 */
	public Object register(String data) {
		if(data == null){
			return null;
		}
		JSONObject param = JSONObject.parseObject(data);
		String userName = param.getString("userName");
		String password = param.getString("password");
		if(StringUtils.isEmpty(userName) || StringUtils.isEmpty(password)){
			return null;
		}
		User user = new User(userName, password);
		String key = userName + password;
		Object memCache = memcacheHepler.get(key);
		if(memCache != null){
			return "dwa";
		}else{
			memcacheHepler.set(key, user, 60 * 10);
		}
		boolean isSuccess = userDao.register(user);
		return isSuccess;
	}
}
