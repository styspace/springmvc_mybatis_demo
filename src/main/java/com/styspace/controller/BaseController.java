/**
 * Package name:com.styspace.controller.base
 * File name:BaseController.java
 * Date:2016年3月16日-下午6:31:09
 * styspace Copyright (c) 2013-2016 All Rights Reserved.
 *
 */
package com.styspace.controller;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;

import com.styspace.constant.ResultCodeConstant;
import com.styspace.constant.ResultDescConstant;
import com.styspace.pojo.GlobalResult;


/**
 * controller基类
 * @ClassName BaseController
 * @Description 
 * @date 2016年3月16日 下午6:31:09
 * @author styspace
 * @version 1.0.0
 *
 */
public class BaseController {
	protected Object getResponse(Object result) {
		ResponseBuilder ok = Response.ok((result == null ? new GlobalResult(ResultCodeConstant.NORMAL, ResultDescConstant.NORMAL) : result),
				MediaType.APPLICATION_JSON);
		
		return ok.build();
	}
}
