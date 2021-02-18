/**
 * Copyright 2021 SinoSoft. All Rights Reserved.
 */
package com.lypz.briefreport.modules.briefreport;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.json.JSONObject;

import com.lypz.briefreport.modules.briefreport.model.BriefReport;
import com.lypz.briefreport.modules.briefreport.po.BriefReportSavePo;
import com.lypz.briefreport.modules.briefreport.service.BriefReportService;
import com.lypz.briefreport.modules.comment.BaseTest;

/**
 * <B>系统名称：</B><BR>
 * <B>模块名称：</B><BR>
 * <B>中文类名：</B><BR>
 * <B>概要说明：</B><BR>
 * 
 * @author 枫林雪山 @lhy
 * @since 2021年2月13日
 */

public class BriefReportTest extends BaseTest {
	private static final Logger logger = LoggerFactory
			.getLogger(BriefReportTest.class);
	@Autowired
	BriefReportService briefReportService;

	// @Test
	public void detailTest() {
		JSONObject json = new JSONObject(briefReportService.detail(1));
		System.err.println(json.toString());
	}

	/**
	 * 
	 * <B>方法名称：saveBriefReport</B><BR>
	 * <B>概要说明：保存简报信息测试方法</B><BR>
	 * 
	 */
	// @Test
	public void saveBriefReport() {
		com.alibaba.fastjson.JSONObject json = new com.alibaba.fastjson.JSONObject();
		BriefReportSavePo briefReport = new BriefReportSavePo();
		json.put("createdAt", new Date());
		json.put("title", "测试简报添加功能20210215");
		json.put("userId", 001001);
		json.put("content", "测试简报添加功能测试简报添加功能测试简报添加功能测试简报添加功能测试简报添加功能");
		json.put("informatioType", 1);
		BeanUtil.copyProperties(json, briefReport, true);
		briefReportService.save(briefReport);
	}

	/**
	 * 
	 * <B>方法名称：updateBriefReport</B><BR>
	 * <B>概要说明：保存简报信息测试方法</B><BR>
	 * 
	 */
	// @Test
	public void updateBriefReport() {
		BriefReport briefReport = new BriefReport();
		briefReport.setId(9);
		briefReport.setTitle("测试简报更新功能20210215");
		briefReportService.update(briefReport);
	}

	/**
	 * 
	 * <B>方法名称：deleteBriefReport</B><BR>
	 * <B>概要说明：删除简报信息测试方法</B><BR>
	 * 
	 */
	// @Test
	public void deleteBriefReport() {
		BriefReport briefReport = new BriefReport();
		briefReport.setId(9);
		briefReportService.delete(9, 1);
	}

	/**
	 * 
	 * <B>方法名称：reportData</B><BR>
	 * <B>概要说明：查询统计数据</B><BR>
	 * 
	 */
	// @Test
	public void reportData() {
		briefReportService.reportData();
	}

	/**
	 * 
	 * <B>方法名称：reviseExportExcel</B><BR>
	 * <B>概要说明：修正导出excel文件</B><BR>
	 * 
	 * @param userId
	 * @return
	 * @return
	 */
	// @Test
	public void reviseExportExcel() {
		briefReportService.reviseExportExcel(1, "D:\\Desktop\\1.xlsx");
	}
}
