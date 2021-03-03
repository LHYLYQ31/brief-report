/**
 * Copyright 2021 SinoSoft. All Rights Reserved.
 */
package com.lypz.briefreport.modules.init.model;

import java.net.URLEncoder;

/**
 * <B>系统名称：</B><BR>
 * <B>模块名称：</B><BR>
 * <B>中文类名：</B><BR>
 * <B>概要说明：</B><BR>
 * 
 * @author 枫林雪山 @lhy
 * @since 2021年2月25日
 */
public class User {
	private Integer userId = 2;
	private String loginName = "登录用户";
	private String deptCode = "001";
	private String organizationName = "2的组织部门";

	/**
	 * <B>取得：</B>loginName<BR>
	 * 
	 * @return String
	 */
	public String getLoginName() {
		return URLEncoder.encode(loginName);
	}

	/**
	 * <B>设定：</B>loginName<BR>
	 * 
	 * @param loginName
	 */
	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	public Integer getUserId() {
		return userId;
	}

	/**
	 * <B>设定：</B>userId<BR>
	 * 
	 * @param userId
	 */
	public void setUserId(Integer userId) {
		this.userId = userId;
	}

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
	 * <B>取得：</B>organizationName<BR>
	 * 
	 * @return String
	 */
	public String getOrganizationName() {
		return URLEncoder.encode(organizationName);
	}

	/**
	 * <B>设定：</B>organizationName<BR>
	 * 
	 * @param organizationName
	 */
	public void setOrganizationName(String organizationName) {
		this.organizationName = organizationName;
	}

}
