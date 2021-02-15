/**
 * Copyright 2021 SinoSoft. All Rights Reserved.
 */
package com.lypz.briefreport.modules.briefreport.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lypz.briefreport.commom.utils.Result;
import com.lypz.briefreport.modules.briefreport.po.BriefReportPo;
import com.lypz.briefreport.modules.briefreport.service.BriefReportService;

/**
 * <B>系统名称：</B><BR>
 * <B>模块名称：</B><BR>
 * <B>中文类名：</B><BR>
 * <B>概要说明：</B><BR>
 * 
 * @author 枫林雪山 @lhy
 * @since 2021年2月13日
 */
@Controller
@RequestMapping("briefreport")
public class BriefreportController {

	@Autowired
	BriefReportService briefReportService;

	@RequestMapping("/index")
	public String index(Model model) {
		// System.out.println(CookieUtils.getCookieValue("userId"));
		model.addAttribute("name", "1234");
		return "index";

	}

	@GetMapping(value = "page", produces = "application/json; charset=UTF-8")
	@ResponseBody
	public Result<?> page(BriefReportPo po) {
		return briefReportService.page(po);

	}
}
