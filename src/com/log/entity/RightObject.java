package com.log.entity;

import java.io.Serializable;

/**
 * weiyongle 20160830
 * 
 * @author Wei 下午02:08:39 2016-8-30
 */
public class RightObject implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String RightID;
	private String RightName;
	private String Rightlink;
	private String ParentID;
	private String Righttype;
	private int Rightlevel;
	private int SortNo;
	private String bussFuncID;
	private String url;

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public RightObject() {
		this.RightID = null;
		this.RightName = null;
		this.Rightlink = null;
		this.ParentID = null;
		this.Righttype = null;
		this.Rightlevel = 0;
		this.bussFuncID = null;
		this.SortNo = 0;
		/**
		 * 新加的
		 */
		this.url = null;
	}

	public String getBussFuncID() {
		return this.bussFuncID;
	}

	public void setBussFuncID(String bussFuncID) {
		this.bussFuncID = bussFuncID;
	}

	public String getRightID() {
		return this.RightID;
	}

	public boolean equals(Object another) {
		return false;
	}

	public String getName() {
		return this.RightName;
	}

	public String getParentID() {
		return this.ParentID;
	}

	public String getHref() {
		return this.Rightlink;
	}

	public String getRightType() {
		return this.Righttype;
	}

	public int getRightLevel() {
		return this.Rightlevel;
	}

	public int getRightSortNo() {
		return this.SortNo;
	}

	public void setRightID(String mID) {
		this.RightID = mID;
	}

	public void setRightName(String mName) {
		this.RightName = mName;
	}

	public void setHref(String href) {
		this.Rightlink = href;
	}

	public void setParentID(String ParentID) {
		this.ParentID = ParentID;
	}

	public void setRightType(String RightType) {
		this.Righttype = RightType;
	}

	public void setRightLevel(int RightLevel) {
		this.Rightlevel = RightLevel;
	}

	public void setRightSortNo(int RightSortNo) {
		this.SortNo = RightSortNo;
	}

	public String toString() {
		return this.RightID + " : " + this.RightName + " : " + this.Rightlink;
	}
}
