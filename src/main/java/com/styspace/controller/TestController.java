/**
 * Package name:controller
 * File name:TestController.java
 * Date:2016年2月29日-下午5:07:52
 * feiniu.com Inc.Copyright (c) 2013-2015 All Rights Reserved.
 *
 */
package com.styspace.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @ClassName TestController
 * @Description 
 * @date 2016年2月29日 下午5:07:52
 * @author tingyong.song
 * @version 1.0.0
 *
 */
@Controller
@RequestMapping("/test")
public class TestController {
	private static Logger logger = LoggerFactory.getLogger(TestController.class);
	
	@RequestMapping(value="/index.do",method=RequestMethod.POST)
	@ResponseBody
	public Object indexDemo(@RequestParam("data") String data){
		logger.debug(data);
		return data;
	}
}
