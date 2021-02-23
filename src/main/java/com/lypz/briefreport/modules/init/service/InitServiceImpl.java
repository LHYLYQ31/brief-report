/**
 * Copyright 2021 SinoSoft. All Rights Reserved.
 */
package com.lypz.briefreport.modules.init.service;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Service;

import com.lypz.briefreport.commom.utils.Result;
import com.lypz.briefreport.commom.utils.ResultUtil;

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
		Map map = new HashMap();
		map.put("userId", 1);
		map.put("userUUId", 1);
		map.put("deptCode", "001001");
		return ResultUtil.success(map);
	}
}
