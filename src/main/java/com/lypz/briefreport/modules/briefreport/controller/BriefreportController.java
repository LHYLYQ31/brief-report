/**
 * Copyright 2021 SinoSoft. All Rights Reserved.
 */
package com.lypz.briefreport.modules.briefreport.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lypz.briefreport.commom.constant.Constant;
import com.lypz.briefreport.commom.utils.LoginUtil;
import com.lypz.briefreport.commom.utils.Result;
import com.lypz.briefreport.commom.utils.ResultUtil;
import com.lypz.briefreport.modules.briefreport.model.BriefReport;
import com.lypz.briefreport.modules.briefreport.po.BriefReportPo;
import com.lypz.briefreport.modules.briefreport.po.BriefReportSavePo;
import com.lypz.briefreport.modules.briefreport.po.ReportPagePo;
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
		model.addAttribute("name", "1234");
		return "index";

	}

	@GetMapping(value = "page", produces = "application/json; charset=UTF-8")
	@ResponseBody
	public Result<?> page(BriefReportPo po, HttpServletRequest request,
			HttpServletResponse respo) {
		String deptCode = LoginUtil.getDeptCode(request);
		if (po.getUnitType() == null || po.getUnitType() == 0) {// 擦报送条件
			if ((StringUtils.isNotBlank(deptCode) && deptCode.length() >= Constant.COUNTY_CODE_LENGTH)
					|| po.getBrStatus() == 2) {
				po.setUserId(Integer.parseInt(LoginUtil.getLoginUserId(request)));

			} else {
				po.setUserId(null);
			}
		}
		// 查反本部门
		if (po.getUnitType() != null && po.getUnitType() != 0
				&& po.getUnitType() == 1) {// 查询本单位 需要根据uuid 查询
			po.setUseUnit(LoginUtil.getDeptNameByCode(request));
		} else {
			po.setUseUnit(null);
		}
		return briefReportService.page(po);

	}

	/**
	 * 
	 * <B>方法名称：reportPage</B><BR>
	 * <B>概要说明：统计分页查询</B><BR>
	 * 
	 * @param po
	 * @return
	 */
	@GetMapping(value = "report-page", produces = "application/json; charset=UTF-8")
	@ResponseBody
	Result<?> reportPage(ReportPagePo po) {
		return briefReportService.reportPage(po);
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

	@PostMapping(value = "batch-delete", produces = "application/json; charset=UTF-8")
	@ResponseBody
	public Result<?> deleteBriefReport(String ids, HttpServletRequest request) {
		if (StringUtils.isNotBlank(ids) && ids.contains(",")) {
			String[] idss = ids.split(",");
			for (String id : idss) {
				briefReportService.delete(Integer.parseInt(id),
						Integer.parseInt(LoginUtil.getLoginUserId(request)));
			}
		} else {
			briefReportService.delete(Integer.parseInt(ids),
					Integer.parseInt(LoginUtil.getLoginUserId(request)));
		}
		return ResultUtil.success(true);
	}

	/**
	 * 
	 * <B>方法名称：reportData</B><BR>
	 * <B>概要说明：查询统计数据</B><BR>
	 * 
	 * @param record
	 * @return
	 */
	@GetMapping(value = "report-data", produces = "application/json; charset=UTF-8")
	@ResponseBody
	Result<?> reportData() {
		return briefReportService.reportData();
	}

	/**
	 * 
	 * <B>方法名称：exportExcel</B><BR>
	 * <B>概要说明：前台导出数据，将导出文件添加标题</B><BR>
	 * 
	 * @param userId
	 * @return
	 */
	@GetMapping(value = "export-excel", produces = "application/json; charset=UTF-8")
	void exportExcel(BriefReportPo po, HttpServletResponse response,
			HttpServletRequest request) throws Exception {
		// po.setUserId(Integer.parseInt(LoginUtil.getLoginUserId(request)));
		briefReportService.exportExcel(po, response);
	}
}
