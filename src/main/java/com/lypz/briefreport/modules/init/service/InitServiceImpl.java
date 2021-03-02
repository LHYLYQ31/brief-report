/**
 * Copyright 2021 SinoSoft. All Rights Reserved.
 */
package com.lypz.briefreport.modules.init.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import com.lypz.briefreport.commom.handle.CRMException;
import com.lypz.briefreport.commom.handle.CRMExceptionEnum;
import com.lypz.briefreport.commom.utils.Result;
import com.lypz.briefreport.commom.utils.ResultUtil;
import com.lypz.briefreport.modules.init.model.User;

/**
 * <B>系统名称：</B><BR>
 * <B>模块名称：</B><BR>
 * <B>中文类名：</B><BR>
 * <B>概要说明：</B><BR>
 * 
 * @author 枫林雪山 @lhy
 * @since 2021年2月20日
 */
@Service
public class InitServiceImpl implements InitService {
	User user;

	@Override
	public Result<?> init(HttpServletRequest request,
			HttpServletResponse response) {
		// String uuid = UUID.randomUUID().toString();
		// request.getSession().setAttribute("userId", 1);
		// request.getSession().setAttribute("userUUId", uuid);
		// request.getSession().setAttribute("code", "001001");
		// System.err.println(uuid);
		// CookieUtils.setCookie("userId", "1", response);
		// CookieUtils.setCookie("userId",
		// "de95fd45-9ab6-4a9a-8dc4-c526e3285e5b",
		// response);
		// CookieUtils.setCookie("code", "001001", response);
		// User
		// Map map = new HashMap();
		// map.put("userId", 2);
		// map.put("userUUId", 2);
		// map.put("deptCode", "001001");
		// map.put("organizationName", "1111");
		if (user == null) {
			user = new User();
		}
		return ResultUtil.success(user);
	}

	@Override
	public Result<?> setUser(User user) {
		if (user.getUserId() != null
				&& StringUtils.isNotBlank(user.getDeptCode())
				&& StringUtils.isNotBlank(user.getLoginName())
				&& StringUtils.isNotBlank(user.getOrganizationName())) {
			this.user = user;
		} else {
			throw new CRMException(CRMExceptionEnum.PARAM_EMPTY);
		}
		return ResultUtil.success(user);
	}
}
