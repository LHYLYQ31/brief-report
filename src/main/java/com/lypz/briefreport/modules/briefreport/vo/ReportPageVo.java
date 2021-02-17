/**
 * Copyright 2021 SinoSoft. All Rights Reserved.
 */
package com.lypz.briefreport.modules.briefreport.vo;

import cn.hutool.json.JSONObject;

/**
 * <B>系统名称：</B><BR>
 * <B>模块名称：</B><BR>
 * <B>中文类名：</B><BR>
 * <B>概要说明：</B><BR>
 * 
 * @author 枫林雪山 @lhy
 * @since 2021年2月17日
 */
public class ReportPageVo {
	private String department;
	private Integer subNumber;
	private Integer adoptNumber;
	private Integer adoptRatio;
	private Integer replyNumber;
	private Integer replyRatio;

	/**
	 * <B>取得：</B>department<BR>
	 * 
	 * @return String
	 */
	public String getDepartment() {
		return department;
	}

	/**
	 * <B>设定：</B>department<BR>
	 * 
	 * @param department
	 */
	public void setDepartment(String department) {
		this.department = department;
	}

	/**
	 * <B>取得：</B>subNumber<BR>
	 * 
	 * @return Integer
	 */
	public Integer getSubNumber() {
		if (subNumber == null)
			return 0;
		return subNumber;
	}

	/**
	 * <B>设定：</B>subNumber<BR>
	 * 
	 * @param subNumber
	 */
	public void setSubNumber(Integer subNumber) {
		this.subNumber = subNumber;
	}

	/**
	 * <B>取得：</B>adoptNumber<BR>
	 * 
	 * @return Integer
	 */
	public Integer getAdoptNumber() {
		if (adoptNumber == null)
			return 0;
		return adoptNumber;
	}

	/**
	 * <B>设定：</B>adoptNumber<BR>
	 * 
	 * @param adoptNumber
	 */
	public void setAdoptNumber(Integer adoptNumber) {
		this.adoptNumber = adoptNumber;
	}

	/**
	 * <B>取得：</B>adoptRatio<BR>
	 * 
	 * @return Integer
	 */
	public Integer getAdoptRatio() {
		if (adoptRatio == null)
			return 0;
		return adoptRatio;
	}

	/**
	 * <B>设定：</B>adoptRatio<BR>
	 * 
	 * @param adoptRatio
	 */
	public void setAdoptRatio(Integer adoptRatio) {
		this.adoptRatio = adoptRatio;
	}

	/**
	 * <B>取得：</B>replyNumber<BR>
	 * 
	 * @return Integer
	 */
	public Integer getReplyNumber() {
		if (replyNumber == null)
			return 0;
		return replyNumber;
	}

	/**
	 * <B>设定：</B>replyNumber<BR>
	 * 
	 * @param replyNumber
	 */
	public void setReplyNumber(Integer replyNumber) {
		this.replyNumber = replyNumber;
	}

	/**
	 * <B>取得：</B>replyRatio<BR>
	 * 
	 * @return Integer
	 */
	public Integer getReplyRatio() {
		if (replyRatio == null)
			return 0;
		return replyRatio;
	}

	/**
	 * <B>设定：</B>replyRatio<BR>
	 * 
	 * @param replyRatio
	 */
	public void setReplyRatio(Integer replyRatio) {
		this.replyRatio = replyRatio;
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
