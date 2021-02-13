/**
 * Copyright 2021 SinoSoft. All Rights Reserved.
 */
package com.lypz.briefreport.modules.briefreport;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import cn.hutool.json.JSONObject;

import com.lypz.briefreport.BriefReportApplication;
import com.lypz.briefreport.modules.briefreport.model.BriefReport;
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
		BriefReport br = briefReportService.detail(1);
		JSONObject json = new JSONObject(br);
		System.err.println(json.toString());
	}
}
