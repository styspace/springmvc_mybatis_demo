/**
 * Package name:com.styspace.controller
 * File name:UserController.java
 * Date:2016年3月24日-下午1:43:07
 * styspace Copyright (c) 2013-2016 All Rights Reserved.
 *
 */
package com.styspace.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.styspace.service.interfaces.UserService;

/**
 * @ClassName UserController
 * @Description 
 * @date 2016年3月24日 下午1:43:07
 * @author styspace
 * @version 1.0.0
 *
 */
@Controller
@RequestMapping("/user")
public class UserController extends BaseController{
	private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);
	
	@Autowired
	private UserService userService;
	
	/**
	 * 用户注册
	 * register
	 * @param data
	 * @return
	 *Object
	 * @exception
	 * @since  1.0.0
	 */
	@RequestMapping(value="/register.do", method=RequestMethod.POST)
	@ResponseBody
	public Object register(@RequestParam("data") String data) {
		LOGGER.info("====================" + Thread.class.getName() + "====================");
		LOGGER.info("Request params: " + data);
		Object result = userService.register(data);
		LOGGER.info("Response result: " + result != null ? result.toString() : null);
		return null;
	}
}
