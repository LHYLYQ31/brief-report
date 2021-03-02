/**
 * Copyright 2021 SinoSoft. All Rights Reserved.
 */
package com.lypz.briefreport.modules.briefreport.vo;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * <B>系统名称：</B><BR>
 * <B>模块名称：</B><BR>
 * <B>中文类名：</B><BR>
 * <B>概要说明：</B><BR>
 * 
 * @author 枫林雪山 @lhy
 * @since 2021年2月15日
 */
public class BriefReportVo {
	private Integer id;
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date createdAt;

	private Integer brStatus;

	private String title;

	private String userUnit;

	private String userName;

	private String informatioType;

	private String submitType;

	/**
	 * <B>取得：</B>informatioType<BR>
	 * 
	 * @return String
	 */
	public String getInformatioType() {
		return informatioType;
	}

	/**
	 * <B>设定：</B>informatioType<BR>
	 * 
	 * @param informatioType
	 */
	public void setInformatioType(String informatioType) {
		this.informatioType = informatioType;
	}

	/**
	 * <B>取得：</B>submitType<BR>
	 * 
	 * @return String
	 */
	public String getSubmitType() {
		return submitType;
	}

	/**
	 * <B>设定：</B>submitType<BR>
	 * 
	 * @param submitType
	 */
	public void setSubmitType(String submitType) {
		this.submitType = submitType;
	}

	/**
	 * <B>取得：</B>id<BR>
	 * 
	 * @return Integer
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * <B>设定：</B>id<BR>
	 * 
	 * @param id
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * <B>取得：</B>createdAt<BR>
	 * 
	 * @return Date
	 */
	public Date getCreatedAt() {
		return createdAt;
	}

	/**
	 * <B>设定：</B>createdAt<BR>
	 * 
	 * @param createdAt
	 */
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	/**
	 * <B>取得：</B>brStatus<BR>
	 * 
	 * @return Integer
	 */
	public Integer getBrStatus() {
		return brStatus;
	}

	/**
	 * <B>设定：</B>brStatus<BR>
	 * 
	 * @param brStatus
	 */
	public void setBrStatus(Integer brStatus) {
		this.brStatus = brStatus;
	}

	/**
	 * <B>取得：</B>title<BR>
	 * 
	 * @return String
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * <B>设定：</B>title<BR>
	 * 
	 * @param title
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * <B>取得：</B>userUnit<BR>
	 * 
	 * @return String
	 */
	public String getUserUnit() {
		return userUnit;
	}

	/**
	 * <B>设定：</B>userUnit<BR>
	 * 
	 * @param userUnit
	 */
	public void setUserUnit(String userUnit) {
		this.userUnit = userUnit;
	}

	/**
	 * <B>取得：</B>userName<BR>
	 * 
	 * @return String
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * <B>设定：</B>userName<BR>
	 * 
	 * @param userName
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}

}
