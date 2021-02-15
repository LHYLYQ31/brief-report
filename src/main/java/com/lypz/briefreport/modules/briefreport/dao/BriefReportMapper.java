package com.lypz.briefreport.modules.briefreport.dao;

import java.util.List;

import com.lypz.briefreport.modules.briefreport.model.BriefReport;

public interface BriefReportMapper {

	int insert(BriefReport record);

	BriefReport selectById(Integer id);

	List<BriefReport> select(BriefReport record);

	int update(BriefReport record);
}