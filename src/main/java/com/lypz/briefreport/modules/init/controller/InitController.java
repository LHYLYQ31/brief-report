/**
 * Copyright 2021 SinoSoft. All Rights Reserved.
 */
package com.lypz.briefreport.modules.init.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lypz.briefreport.commom.utils.Result;
import com.lypz.briefreport.modules.init.service.InitService;

/**
 * <B>系统名称：</B><BR>
 * <B>模块名称：</B><BR>
 * <B>中文类名：</B><BR>
 * <B>概要说明：</B><BR>
 * 
 * @author 枫林雪山 @lhy
 * @since 2021年2月20日
 */
@RestController
@RequestMapping("init")
public class InitController {
	@Autowired
	InitService initService;

	@RequestMapping("init")
	public Result<?> init(HttpServletRequest request,
			HttpServletResponse response) {
		return initService.init(request, response);
	}
}
