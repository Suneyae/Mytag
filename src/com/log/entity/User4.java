package com.log.entity;

import java.sql.Date;

/**
 * 用于给myeasyui_datagrid.jsp传入数据
 * 
 * @author Wei
 * @time 2016年9月18日 下午10:05:01
 */
public class User4 {
	private int id;
	private String username;
	private String email;
	private Date datetime;

	public User4() {

	}

	public User4(int id, String username, String email, Date datetime) {
		super();
		this.id = id;
		this.username = username;
		this.email = email;
		this.datetime = datetime;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getDatetime() {
		return datetime;
	}

	public void setDatetime(Date datetime) {
		this.datetime = datetime;
	}

	

}
