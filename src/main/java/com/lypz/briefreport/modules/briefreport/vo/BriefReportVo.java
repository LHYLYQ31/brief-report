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

	private String unit;

	private String author;

	private Integer informatioType;

	private Integer submitType;

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
	 * <B>取得：</B>unit<BR>
	 * 
	 * @return String
	 */
	public String getUnit() {
		return unit;
	}

	/**
	 * <B>设定：</B>unit<BR>
	 * 
	 * @param unit
	 */
	public void setUnit(String unit) {
		this.unit = unit;
	}

	/**
	 * <B>取得：</B>author<BR>
	 * 
	 * @return String
	 */
	public String getAuthor() {
		return author;
	}

	/**
	 * <B>设定：</B>author<BR>
	 * 
	 * @param author
	 */
	public void setAuthor(String author) {
		this.author = author;
	}

	/**
	 * <B>取得：</B>informatioType<BR>
	 * 
	 * @return Integer
	 */
	public Integer getInformatioType() {
		return informatioType;
	}

	/**
	 * <B>设定：</B>informatioType<BR>
	 * 
	 * @param informatioType
	 */
	public void setInformatioType(Integer informatioType) {
		this.informatioType = informatioType;
	}

	/**
	 * <B>取得：</B>submitType<BR>
	 * 
	 * @return Integer
	 */
	public Integer getSubmitType() {
		return submitType;
	}

	/**
	 * <B>设定：</B>submitType<BR>
	 * 
	 * @param submitType
	 */
	public void setSubmitType(Integer submitType) {
		this.submitType = submitType;
	}

}
