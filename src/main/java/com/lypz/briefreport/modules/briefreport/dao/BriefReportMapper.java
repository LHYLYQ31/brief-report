package com.lypz.briefreport.modules.briefreport.dao;

import com.lypz.briefreport.modules.briefreport.model.BriefReport;

public interface BriefReportMapper {

	int insert(BriefReport record);

	BriefReport selectById(Integer id);

	int update(BriefReport record);

}