/**
 * Package name:com.styspace.pojo
 * File name:User.java
 * Date:2016年3月17日-下午6:10:41
 * styspace Copyright (c) 2013-2016 All Rights Reserved.
 *
 */
package com.styspace.pojo;

import java.io.Serializable;

/**
 * @ClassName User
 * @Description 
 * @date 2016年3月17日 下午6:10:41
 * @author styspace
 * @version 1.0.0
 *
 */
public class User implements Serializable {
	/**
	 * serialVersionUID:TODO
	 *
	 * @since 1.0.0
	 */
	
	private static final long serialVersionUID = 1L;
	/**
	 * 用户id
	 */
	private int id;
	/**
	 * 用户名
	 */
	private String userName;
	/**
	 * 密码
	 */
	private String password;
	/**
	 * id
	 *
	 * @return  the id
	 * @since   1.0.0
	*/
	
	public int getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * userName
	 *
	 * @return  the userName
	 * @since   1.0.0
	*/
	
	public String getUserName() {
		return userName;
	}
	/**
	 * @param userName the userName to set
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}
	/**
	 * password
	 *
	 * @return  the password
	 * @since   1.0.0
	*/
	
	public String getPassword() {
		return password;
	}
	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	
	public User(int id, String userName, String password) {
		super();
		this.id = id;
		this.userName = userName;
		this.password = password;
	}
	
	public User(String userName, String password) {
		super();
		this.userName = userName;
		this.password = password;
	}
	
	public String toString() {
		return "id:" + id + "\t userName" + userName;
	}
}
