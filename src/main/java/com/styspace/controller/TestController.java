/**
 * Package name:controller
 * File name:TestController.java
 * Date:2016年2月29日-下午5:07:52
 * feiniu.com Inc.Copyright (c) 2013-2015 All Rights Reserved.
 *
 */
package com.styspace.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @ClassName TestController
 * @Description 
 * @date 2016年2月29日 下午5:07:52
 * @author tingyong.song
 * @version 1.0.0
 *
 */
@Controller
public class TestController {
	
	@RequestMapping(value="index.do")
	public void indexDemo(){
		System.out.println(Math.floor(3/2));
	}
}
