/**
 * Package name:com.styspace.pojo
 * File name:GlobalResult.java
 * Date:2016年3月16日-下午6:09:41
 * styspace Copyright (c) 2013-2016 All Rights Reserved.
 *
 */
package com.styspace.pojo;

import com.alibaba.fastjson.JSONObject;
import com.styspace.constant.ResultCodeConstant;
import com.styspace.constant.ResultDescConstant;


/**
 * 统一返回数据结构格式
 * @ClassName GlobalResult
 * @Description 
 * @date 2016年3月16日 下午6:09:41
 * @author styspace
 * @version 1.0.0
 *
 */
public class GlobalResult {
	/**
	 * 时间花销
	 */
	private long time;
	/**
	 * 状态码
	 */
	private int code;
	/**
	 * 描述信息
	 */
	private String desc;
	/**
	 * 返回数据
	 */
	private Object body;
	/**
	 * time
	 *
	 * @return  the time
	 * @since   1.0.0
	*/
	
	public long getTime() {
		return time;
	}
	/**
	 * @param time the time to set
	 */
	public void setTime(long time) {
		this.time = time;
	}
	/**
	 * code
	 *
	 * @return  the code
	 * @since   1.0.0
	*/
	
	public int getCode() {
		return code;
	}
	/**
	 * @param code the code to set
	 */
	public void setCode(int code) {
		this.code = code;
	}
	/**
	 * desc
	 *
	 * @return  the desc
	 * @since   1.0.0
	*/
	
	public String getDesc() {
		return desc;
	}
	/**
	 * @param desc the desc to set
	 */
	public void setDesc(String desc) {
		this.desc = desc;
	}
	/**
	 * body
	 *
	 * @return  the body
	 * @since   1.0.0
	*/
	
	public Object getBody() {
		return body;
	}
	/**
	 * @param body the body to set
	 */
	public void setBody(Object body) {
		this.body = body;
	}
	
	public GlobalResult(long time, int code, String desc, Object body){
		this.time = time;
		this.code = code;
		this.desc = desc;
		this.body = body;
	}
	
	public GlobalResult(long time, Object body){
		this.time = time;
		this.code = ResultCodeConstant.OK;
		this.desc = ResultDescConstant.OK;
		this.body = body;
	}
	
	public GlobalResult(int code, String desc){
		this.code = code;
		this.desc = desc;
		if(this.body == null){
			this.body = new JSONObject();
		}
	}

	public String toString() {
		return "code:" + code + "\t desc:" + desc + "\t time:" + time + "\t body:" + body;
	}
}
