package com.lypz.briefreport.modules.briefreport.dao;

import java.util.List;

import com.lypz.briefreport.modules.briefreport.model.BriefReport;
import com.lypz.briefreport.modules.briefreport.po.BriefReportPo;

public interface BriefReportMapper {

	int insert(BriefReport record);

	BriefReport selectById(Integer id);

	List<BriefReport> select(BriefReport record);

	List<BriefReport> page(BriefReportPo record);

	int update(BriefReport record);
}