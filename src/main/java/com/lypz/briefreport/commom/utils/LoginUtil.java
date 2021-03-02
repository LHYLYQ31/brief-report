/**
 * Copyright 2021 SinoSoft. All Rights Reserved.
 */
package com.lypz.briefreport.commom.utils;

import javax.servlet.http.HttpServletRequest;

import com.lypz.briefreport.commom.handle.CRMException;
import com.lypz.briefreport.commom.handle.CRMExceptionEnum;

/**
 * <B>系统名称：</B><BR>
 * <B>模块名称：</B><BR>
 * <B>中文类名：</B><BR>
 * <B>概要说明：</B><BR>
 * 
 * @author 枫林雪山 @lhy
 * @since 2021年2月16日
 */
public class LoginUtil {

	public static String getLoginUserId(HttpServletRequest request) {
		Object userId = request.getSession().getAttribute("userId");
		if (userId != null) {
			return userId.toString();
		} else {
			throw new CRMException(CRMExceptionEnum.LOGIN_LOSE_EFFICACY_ERROR);
		}
	}

	public static String getDeptCode(HttpServletRequest request) {
		Object code = request.getSession().getAttribute("code");
		if (code != null) {
			return code.toString();
		} else {
			throw new CRMException(CRMExceptionEnum.LOGIN_LOSE_EFFICACY_ERROR);
		}
	}

	public static String getDeptNameByCode(HttpServletRequest request) {

		Object organizationName = request.getSession().getAttribute(
				"organizationName");
		if (organizationName != null) {
			return organizationName.toString();
		} else {
			throw new CRMException(CRMExceptionEnum.LOGIN_LOSE_EFFICACY_ERROR);
		}
	}

	public static String getLoginName(HttpServletRequest request) {

		return request.getSession().getAttribute("loginName").toString();

	}

}
