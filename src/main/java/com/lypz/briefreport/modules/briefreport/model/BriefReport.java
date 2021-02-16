package com.lypz.briefreport.modules.briefreport.model;

import java.util.Date;

import cn.hutool.json.JSONObject;

import com.fasterxml.jackson.annotation.JsonFormat;

public class BriefReport {

	private Integer id;
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date createdAt;
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date updatedAt;
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date deletedAt;

	private Integer isDeleted;

	private Integer userId;

	private Integer brStatus;

	private String title;

	private String content;

	private Integer useStatus;

	private String unit;

	private String author;

	private String contactInformation;

	private Integer informatioType;

	private Integer isOrderManuscript;

	private Integer submitType;

	private String useUnit;

	private Integer score;

	private String reviewer;

	private String lssuer;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	public Date getDeletedAt() {
		return deletedAt;
	}

	public void setDeletedAt(Date deletedAt) {
		this.deletedAt = deletedAt;
	}

	public Integer getIsDeleted() {
		return isDeleted;
	}

	public void setIsDeleted(Integer isDeleted) {
		this.isDeleted = isDeleted;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Integer getBrStatus() {
		return brStatus;
	}

	public void setBrStatus(Integer brStatus) {
		this.brStatus = brStatus;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title == null ? null : title.trim();
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content == null ? null : content.trim();
	}

	public Integer getUseStatus() {
		return useStatus;
	}

	public void setUseStatus(Integer useStatus) {
		this.useStatus = useStatus;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit == null ? null : unit.trim();
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author == null ? null : author.trim();
	}

	public String getContactInformation() {
		return contactInformation;
	}

	public void setContactInformation(String contactInformation) {
		this.contactInformation = contactInformation == null ? null
				: contactInformation.trim();
	}

	public Integer getInformatioType() {
		return informatioType;
	}

	public void setInformatioType(Integer informatioType) {
		this.informatioType = informatioType;
	}

	public Integer getIsOrderManuscript() {
		return isOrderManuscript;
	}

	public void setIsOrderManuscript(Integer isOrderManuscript) {
		this.isOrderManuscript = isOrderManuscript;
	}

	public Integer getSubmitType() {
		return submitType;
	}

	public void setSubmitType(Integer submitType) {
		this.submitType = submitType;
	}

	public String getUseUnit() {
		return useUnit;
	}

	public void setUseUnit(String useUnit) {
		this.useUnit = useUnit == null ? null : useUnit.trim();
	}

	public Integer getScore() {
		return score;
	}

	public void setScore(Integer score) {
		this.score = score;
	}

	public String getReviewer() {
		return reviewer;
	}

	public void setReviewer(String reviewer) {
		this.reviewer = reviewer == null ? null : reviewer.trim();
	}

	public String getLssuer() {
		return lssuer;
	}

	public void setLssuer(String lssuer) {
		this.lssuer = lssuer == null ? null : lssuer.trim();
	}

	/**
	 * <B>方法名称：</B><BR>
	 * <B>概要说明：</B><BR>
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return new JSONObject(this).toString();
	}
}