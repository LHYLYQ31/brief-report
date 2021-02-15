/**
 * Copyright 2021 SinoSoft. All Rights Reserved.
 */
package com.lypz.briefreport.modules.briefreport.service;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lypz.briefreport.commom.constant.Constant;
import com.lypz.briefreport.commom.utils.Result;
import com.lypz.briefreport.commom.utils.ResultUtil;
import com.lypz.briefreport.modules.attachment.model.Attachment;
import com.lypz.briefreport.modules.attachment.service.AttachmentService;
import com.lypz.briefreport.modules.briefreport.dao.BriefReportMapper;
import com.lypz.briefreport.modules.briefreport.model.BriefReport;
import com.lypz.briefreport.modules.briefreport.po.BriefReportPo;
import com.lypz.briefreport.modules.briefreport.vo.BriefReportDetailVo;
import com.lypz.briefreport.modules.briefreport.vo.BriefReportVo;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.json.JSONObject;

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
		PageInfo<BriefReportVo> pageInfo = new PageInfo<BriefReportVo>(formPageDate(list));
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

	/**
	 * 
	 * <B>方法名称：save</B><BR>
	 * <B>概要说明：保存简报信息</B><BR>
	 */
	@Override
	public int save(com.alibaba.fastjson.JSONObject jsonObject) {
		BriefReport briefReport = com.alibaba.fastjson.JSONObject.parseObject(jsonObject.toString(), BriefReport.class);
		// 简报默认起草状态为未上报（状态值为0）
		briefReport.setBrStatus(Constant.NOT_REPORTED);
		// 简报默认删除状态为未上报（状态值为1）
		briefReport.setIsDeleted(Constant.NOT_DELETED);
		int flag = briefReportMapper.insert(briefReport);
		return flag;
	}

	/**
	 *
	 * <B>方法名称：update</B><BR>
	 * <B>概要说明：更新简报信息</B><BR>
	 *
	 * @param jsonObject
	 *            简报信息
	 * @return int 结果值
	 */
	@Override
	public int update(com.alibaba.fastjson.JSONObject jsonObject) {
		BriefReport briefReport = com.alibaba.fastjson.JSONObject.parseObject(jsonObject.toString(), BriefReport.class);
		int flag = briefReportMapper.update(briefReport);
		return flag;
	}

	/**
	 *
	 * <B>方法名称：delete</B><BR>
	 * <B>概要说明：删除简报信息</B><BR>
	 *
	 * @param jsonObject
	 *            简报信息
	 * @return int 结果值
	 */
	@Override
	public int delete(com.alibaba.fastjson.JSONObject jsonObject) {
		BriefReport briefReport = com.alibaba.fastjson.JSONObject.parseObject(jsonObject.toString(), BriefReport.class);
		// 修改简报删除状态为未上报（状态值为1）
		briefReport.setIsDeleted(Constant.DELETED);
		int flag = briefReportMapper.update(briefReport);
		return flag;
	}
}
