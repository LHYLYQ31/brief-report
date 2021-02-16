/**
 * Copyright 2021 SinoSoft. All Rights Reserved.
 */
package com.lypz.briefreport.modules.briefreport.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lypz.briefreport.commom.utils.LoginUtil;
import com.lypz.briefreport.commom.utils.Result;
import com.lypz.briefreport.modules.briefreport.model.BriefReport;
import com.lypz.briefreport.modules.briefreport.po.BriefReportPo;
import com.lypz.briefreport.modules.briefreport.po.BriefReportSavePo;
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

	@GetMapping(value = "detail", produces = "application/json; charset=UTF-8")
	@ResponseBody
	public Result<?> detail(Integer id) {
		return briefReportService.detail(id);

	}

	/**
	 * 
	 * <B>方法名称：saveBriefReport</B><BR>
	 * <B>概要说明：保存简报信息</B><BR>
	 * 
	 * @param jsonObject
	 *            前段返回json数据
	 * @return int 结果值
	 */
	@PostMapping("add")
	@ResponseBody
	public Result<?> saveBriefReport(BriefReportSavePo record,
			HttpServletRequest request) {
		record.setUserId(Integer.parseInt(LoginUtil.getLoginUserId(request)));
		return briefReportService.save(record);
	}

	/**
	 * 
	 * <B>方法名称：updateBriefReport</B><BR>
	 * <B>概要说明：更新简报信息</B><BR>
	 * 
	 * @param jsonObject
	 *            前段返回json数据
	 * @return int 返回结果集
	 */
	@PostMapping(value = "update", produces = "application/json; charset=UTF-8")
	@ResponseBody
	public Result<?> updateBriefReport(BriefReport record) {
		return briefReportService.update(record);
	}

	/**
	 * 
	 * <B>方法名称：deleteBriefReport</B><BR>
	 * <B>概要说明：删除简报信息</B><BR>
	 * 
	 * @param jsonObject
	 *            前段返回json数据
	 * @return int 返回结果集
	 */
	@PostMapping(value = "delete/{id}", produces = "application/json; charset=UTF-8")
	@ResponseBody
	public Result<?> deleteBriefReport(@PathVariable Integer id,
			HttpServletRequest request) {
		return briefReportService.delete(id,
				Integer.parseInt(LoginUtil.getLoginUserId(request)));
	}
}
