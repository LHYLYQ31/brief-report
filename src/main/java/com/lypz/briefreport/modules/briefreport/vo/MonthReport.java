/**
 * Copyright 2021 SinoSoft. All Rights Reserved.
 */
package com.lypz.briefreport.modules.briefreport.vo;

/**
 * <B>系统名称：</B><BR>
 * <B>模块名称：</B><BR>
 * <B>中文类名：</B><BR>
 * <B>概要说明：</B><BR>
 * 
 * @author 枫林雪山 @lhy
 * @since 2021年2月17日
 */
public class MonthReport {

	private Integer countNum;

	private String createdAt;

	/**
	 * <B>取得：</B>countNum<BR>
	 * 
	 * @return Integer
	 */
	public Integer getCountNum() {
		if (countNum == null)
			return 0;
		return countNum;
	}

	/**
	 * <B>设定：</B>countNum<BR>
	 * 
	 * @param countNum
	 */
	public void setCountNum(Integer countNum) {
		this.countNum = countNum;
	}

	/**
	 * <B>取得：</B>createdAt<BR>
	 * 
	 * @return String
	 */
	public String getCreatedAt() {
		return createdAt;
	}

	/**
	 * <B>设定：</B>createdAt<BR>
	 * 
	 * @param createdAt
	 */
	public void setCreatedAt(String createdAt) {
		this.createdAt = createdAt;
	}

}
