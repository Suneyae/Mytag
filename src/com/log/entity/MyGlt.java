package com.log.entity;

/**
 * 模拟系统里的多记录表
 * 
 * @author Wei
 * @time 2016年9月20日 上午12:12:47
 */
public class MyGlt {
	private int id;
	private String idglt;
	private String title;
	private String colhead;
	private String SELECTSTR;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getIdglt() {
		return idglt;
	}

	public void setIdglt(String idglt) {
		this.idglt = idglt;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getColhead() {
		return colhead;
	}

	public void setColhead(String colhead) {
		this.colhead = colhead;
	}

	public String getSELECTSTR() {
		return SELECTSTR;
	}

	public void setSELECTSTR(String sELECTSTR) {
		SELECTSTR = sELECTSTR;
	}

	public MyGlt(int id, String idglt, String title, String colhead, String sELECTSTR) {
		super();
		this.id = id;
		this.idglt = idglt;
		this.title = title;
		this.colhead = colhead;
		SELECTSTR = sELECTSTR;
	}

	public MyGlt() {
		super();
	}

}
