/**
 * Package name:com.styspace.mapper
 * File name:UerMapper.java
 * Date:2016年3月25日-下午5:20:25
 * styspace Copyright (c) 2013-2016 All Rights Reserved.
 *
 */
package com.styspace.mapper;

import com.styspace.pojo.User;

/**
 * 用户mapper接口，对应应该有mapper.xml文件
 * @ClassName UerMapper
 * @Description 
 * @date 2016年3月25日 下午5:20:25
 * @author styspace
 * @version 1.0.0
 *
 */
public interface UserMapper {
	/**
	 * 插入用户信息
	 * insertUser
	 * @param user 用户信息
	 * @return
	 *boolean
	 * @exception
	 * @since  1.0.0
	 */
	public boolean insertUser(User user);
}
