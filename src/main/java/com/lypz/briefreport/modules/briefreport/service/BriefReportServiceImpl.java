/**
 * Copyright 2021 SinoSoft. All Rights Reserved.
 */
package com.lypz.briefreport.modules.briefreport.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.lypz.briefreport.modules.briefreport.dao.BriefReportMapper;
import com.lypz.briefreport.modules.briefreport.model.BriefReport;

/**
 * <B>系统名称：</B><BR>
 * <B>模块名称：</B><BR>
 * <B>中文类名：</B><BR>
 * <B>概要说明：</B><BR>
 * 
 * @author 枫林雪山 @lhy
 * @since 2021年2月13日
 */
@Service
public class BriefReportServiceImpl implements BriefReportService {

	@Resource
	BriefReportMapper briefReportMapper;

	/**
	 * <B>方法名称：</B><BR>
	 * <B>概要说明：</B><BR>
	 * 
	 * @see com.lypz.briefreport.modules.briefreport.service.BriefReportService#detail(java.lang.Integer)
	 */
	@Override
	public BriefReport detail(Integer id) {
		return briefReportMapper.selectById(id);
	}
}
