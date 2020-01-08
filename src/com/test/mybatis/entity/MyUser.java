package com.test.mybatis.entity;

public class MyUser {
	private Long id;

	/*
	 * user specified user ID
	 */
	private String username;
	/*
	 * encrypted password
	 */
	private EncryptedString password;

	String administrator;

	public MyUser() {
		setUsername(new String());
		setPassword(new EncryptedString());
//		setAdministrator("我是admin");
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public EncryptedString getPassword() {
		return password;
	}

	public void setPassword(EncryptedString password) {
		this.password = password;
	}

	public String getAdministrator() {
		return administrator;
	}

	public void setAdministrator(String administrator) {
		this.administrator = administrator;
	}

	@Override
	public String toString() {
		return "MyUser [id=" + id + ", username=" + username + ", password=" + password + ", administrator="
				+ administrator + "]";
	}
	
}
