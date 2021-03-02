/**
 * Copyright 2021 SinoSoft. All Rights Reserved.
 */
package com.lypz.briefreport.modules.briefreport.po;

import cn.hutool.json.JSONUtil;

import com.lypz.briefreport.modules.briefreport.model.BriefReport;

/**
 * <B>系统名称：</B><BR>
 * <B>模块名称：</B><BR>
 * <B>中文类名：</B><BR>
 * <B>概要说明：</B><BR>
 * 
 * @author 枫林雪山 @lhy
 * @since 2021年2月15日
 */
public class BriefReportPo extends BriefReport {

	private Integer page;

	private Integer limit;
	// 1 本单位 2 全部单位
	private Integer unitType;
	private String endTime;
	private String startTime;

	private String deptCode;

	/**
	 * <B>取得：</B>deptCode<BR>
	 * 
	 * @return String
	 */
	public String getDeptCode() {
		return deptCode;
	}

	/**
	 * <B>设定：</B>deptCode<BR>
	 * 
	 * @param deptCode
	 */
	public void setDeptCode(String deptCode) {
		this.deptCode = deptCode;
	}

	/**
	 * <B>取得：</B>endTime<BR>
	 * 
	 * @return String
	 */
	public String getEndTime() {
		return endTime;
	}

	/**
	 * <B>设定：</B>endTime<BR>
	 * 
	 * @param endTime
	 */
	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	/**
	 * <B>取得：</B>startTime<BR>
	 * 
	 * @return String
	 */
	public String getStartTime() {
		return startTime;
	}

	/**
	 * <B>设定：</B>startTime<BR>
	 * 
	 * @param startTime
	 */
	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	/**
	 * <B>取得：</B>unitType<BR>
	 * 
	 * @return Integer
	 */
	public Integer getUnitType() {
		return unitType;
	}

	/**
	 * <B>设定：</B>unitType<BR>
	 * 
	 * @param unitType
	 */
	public void setUnitType(Integer unitType) {
		this.unitType = unitType;
	}

	/**
	 * <B>取得：</B>page<BR>
	 * 
	 * @return Integer
	 */
	public Integer getPage() {
		return page;
	}

	/**
	 * <B>设定：</B>page<BR>
	 * 
	 * @param page
	 */
	public void setPage(Integer page) {
		this.page = page;
	}

	/**
	 * <B>取得：</B>limit<BR>
	 * 
	 * @return Integer
	 */
	public Integer getLimit() {
		return limit;
	}

	/**
	 * <B>设定：</B>limit<BR>
	 * 
	 * @param limit
	 */
	public void setLimit(Integer limit) {
		this.limit = limit;
	}

	/**
	 * <B>方法名称：</B><BR>
	 * <B>概要说明：</B><BR>
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return JSONUtil.toJsonStr(this);
	}

}
