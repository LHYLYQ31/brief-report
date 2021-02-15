/**
 * Copyright 2021 SinoSoft. All Rights Reserved.
 */
package com.lypz.briefreport.modules.briefreport.service;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.json.JSONObject;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lypz.briefreport.commom.utils.Result;
import com.lypz.briefreport.commom.utils.ResultUtil;
import com.lypz.briefreport.modules.attachment.model.Attachment;
import com.lypz.briefreport.modules.attachment.service.AttachmentService;
import com.lypz.briefreport.modules.briefreport.dao.BriefReportMapper;
import com.lypz.briefreport.modules.briefreport.model.BriefReport;
import com.lypz.briefreport.modules.briefreport.po.BriefReportPo;
import com.lypz.briefreport.modules.briefreport.vo.BriefReportDetailVo;
import com.lypz.briefreport.modules.briefreport.vo.BriefReportVo;

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
	@Resource
	AttachmentService attachmentService;

	/**
	 * <B>方法名称：</B><BR>
	 * <B>概要说明：</B><BR>
	 * 
	 * @see com.lypz.briefreport.modules.briefreport.service.BriefReportService#detail(java.lang.Integer)
	 */
	@Override
	public Result<?> detail(Integer id) {
		if (id == null || id == 0) {
			return ResultUtil.success(new JSONObject());
		}
		return ResultUtil.success(formDetail(briefReportMapper.selectById(id)));
	}

	private BriefReportDetailVo formDetail(BriefReport br) {
		BriefReportDetailVo vo = new BriefReportDetailVo();

		BeanUtil.copyProperties(br, vo, true);
		List<Attachment> list = attachmentService.list(1);
		vo.setAttachments(list);
		return vo;
	}

	/**
	 * <B>方法名称：</B><BR>
	 * <B>概要说明：</B><BR>
	 * 
	 * @see com.lypz.briefreport.modules.briefreport.service.BriefReportService#page(com.lypz.briefreport.modules.briefreport.model.BriefReport)
	 */
	@Override
	public Result<?> page(BriefReportPo po) {
		PageHelper.startPage(po.getPageNum(), po.getPageSize());
		List<BriefReport> list = briefReportMapper.select(po);
		PageInfo<BriefReportVo> pageInfo = new PageInfo<BriefReportVo>(
				formPageDate(list));
		return ResultUtil.success(pageInfo);

	}

	private List<BriefReportVo> formPageDate(List<BriefReport> list) {

		List<BriefReportVo> newlist = new ArrayList<BriefReportVo>();
		for (BriefReport br : list) {
			BriefReportVo vo = new BriefReportVo();
			BeanUtil.copyProperties(br, vo, true);
			newlist.add(vo);
		}
		return newlist;
	}
}
