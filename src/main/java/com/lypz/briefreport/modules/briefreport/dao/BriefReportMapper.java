package com.lypz.briefreport.modules.briefreport.dao;

import java.util.List;

import com.lypz.briefreport.modules.briefreport.model.BriefReport;
import com.lypz.briefreport.modules.briefreport.po.BriefReportPo;
import com.lypz.briefreport.modules.briefreport.po.ReportPagePo;
import com.lypz.briefreport.modules.briefreport.vo.MonthReport;
import com.lypz.briefreport.modules.briefreport.vo.ReportPageVo;

public interface BriefReportMapper {

	int insert(BriefReport record);

	BriefReport selectById(Integer id);

	List<BriefReport> select(BriefReport record);

	List<BriefReport> page(BriefReportPo record);

	List<ReportPageVo> reportPage(ReportPagePo po);

	Integer selectCount(BriefReport record);

	// 按月统计数据
	List<MonthReport> selectCountByMonth(BriefReport record);

	int update(BriefReport record);
}