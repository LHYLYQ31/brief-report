/**
 * Copyright 2021 SinoSoft. All Rights Reserved.
 */
package com.lypz.briefreport.modules.briefreport;

import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.json.JSONObject;

import com.lypz.briefreport.BriefReportApplication;
import com.lypz.briefreport.modules.briefreport.model.BriefReport;
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

@RunWith(SpringRunner.class)
@SpringBootTest(classes = BriefReportApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class BriefReportTest {
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
	@Test
	public void deleteBriefReport() {
		BriefReport briefReport = new BriefReport();
		briefReport.setId(9);
		briefReportService.delete(9);
	}
}
