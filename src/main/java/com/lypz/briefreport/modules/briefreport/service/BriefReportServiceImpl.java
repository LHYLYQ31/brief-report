/**
 * Copyright 2021 SinoSoft. All Rights Reserved.
 */
package com.lypz.briefreport.modules.briefreport.service;

import java.io.File;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.json.JSONObject;
import cn.hutool.poi.excel.ExcelUtil;
import cn.hutool.poi.excel.ExcelWriter;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lypz.briefreport.commom.constant.Constant;
import com.lypz.briefreport.commom.handle.CRMException;
import com.lypz.briefreport.commom.handle.CRMExceptionEnum;
import com.lypz.briefreport.commom.utils.DateUtil;
import com.lypz.briefreport.commom.utils.Result;
import com.lypz.briefreport.commom.utils.ResultUtil;
import com.lypz.briefreport.modules.attachment.model.Attachment;
import com.lypz.briefreport.modules.attachment.service.AttachmentService;
import com.lypz.briefreport.modules.briefreport.dao.BriefReportMapper;
import com.lypz.briefreport.modules.briefreport.model.BriefReport;
import com.lypz.briefreport.modules.briefreport.po.BriefReportPo;
import com.lypz.briefreport.modules.briefreport.po.BriefReportSavePo;
import com.lypz.briefreport.modules.briefreport.po.ReportPagePo;
import com.lypz.briefreport.modules.briefreport.vo.BriefReportDetailVo;
import com.lypz.briefreport.modules.briefreport.vo.BriefReportVo;
import com.lypz.briefreport.modules.briefreport.vo.ReportPageVo;
import com.lypz.briefreport.modules.dictionary.dao.DictionaryMapper;

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
@Transactional
public class BriefReportServiceImpl implements BriefReportService {

	@Resource
	BriefReportMapper briefReportMapper;
	@Resource
	AttachmentService attachmentService;
	@Resource
	DictionaryMapper dictionaryMapper;
	@Value("${brie.freport.path}")
	String brieFreportPath;

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
		Attachment att = new Attachment();
		att.setBusinessType(1);
		att.setBusinessId(br.getId().toString());
		List<Attachment> list = attachmentService.list(att);
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
		if (po.getUnitType() != null && po.getUnitType() != 0
				&& po.getUnitType() == 1) {// 查询本单位 需要根据uuid 查询
			po.setUnit("");
		}
		PageHelper.startPage(po.getPageNum(), po.getPageSize());
		List<BriefReport> list = briefReportMapper.page(po);
		PageInfo<BriefReportVo> pageInfo = new PageInfo<BriefReportVo>(
				formPageDate(list));
		return ResultUtil.success(pageInfo);

	}

	private List<BriefReportVo> formPageDate(List<BriefReport> list) {

		List<BriefReportVo> newlist = new ArrayList<BriefReportVo>();
		for (BriefReport br : list) {
			BriefReportVo vo = new BriefReportVo();
			BeanUtil.copyProperties(br, vo, true);
			vo.setInformatioType(dictionaryMapper.selectById(
					br.getInformatioType()).getDictionaryName());
			vo.setSubmitType(dictionaryMapper.selectById(br.getSubmitType())
					.getDictionaryName());
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
	public Result<?> save(BriefReportSavePo record) {
		// 简报默认起草状态为未上报（状态值为0）
		// record.setBrStatus(Constant.NOT_REPORTED);
		// 简报默认删除状态为未上报（状态值为1）
		record.setIsDeleted(Constant.NOT_DELETED);
		record.setCreatedAt(new Date());
		int flag = briefReportMapper.insert(record);
		if (flag == 1) {// 更新附件关系
			if (StringUtils.isNotBlank(record.getAttachmentIds())) {
				attachmentService.update(record.getAttachmentIds().split(","),
						record.getId());
			}
			return ResultUtil.success(true);
		} else {
			return ResultUtil.success(false);
		}
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
	public Result<?> update(BriefReport record) {
		record.setUpdatedAt(new Date());
		int flag = briefReportMapper.update(record);
		if (flag == 1) {
			return ResultUtil.success(true);
		} else {
			return ResultUtil.success(false);
		}
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
	public Result<?> delete(Integer id, Integer userId) {
		BriefReport br = new BriefReport();
		// 修改简报删除状态为未上报（状态值为1）
		br.setIsDeleted(Constant.DELETED);
		br.setDeletedAt(new Date());
		br.setId(id);
		BriefReport selectbr = briefReportMapper.selectById(id);
		if (selectbr != null && userId.equals(selectbr.getUserId())) {
			int flag = briefReportMapper.update(br);
			if (flag == 1) {
				return ResultUtil.success(true);
			} else {
				return ResultUtil.success(false);
			}
		} else {
			throw new CRMException(CRMExceptionEnum.NO_POWER_ERROR);
		}

	}

	/**
	 * <B>方法名称：</B><BR>
	 * <B>概要说明：</B><BR>
	 * 
	 * @see com.lypz.briefreport.modules.briefreport.service.BriefReportService#reportPage(com.lypz.briefreport.modules.briefreport.po.ReportPagePo)
	 */
	@Override
	public Result<?> reportPage(ReportPagePo po) {
		PageHelper.startPage(po.getPageNum(), po.getPageSize());
		List<ReportPageVo> list = briefReportMapper.reportPage(po);
		PageInfo<ReportPageVo> pageInfo = new PageInfo<ReportPageVo>(list);
		return ResultUtil.success(pageInfo);
	}

	/**
	 * <B>方法名称：</B><BR>
	 * <B>概要说明：</B><BR>
	 * 
	 * @see com.lypz.briefreport.modules.briefreport.service.BriefReportService#reportData(com.lypz.briefreport.modules.briefreport.model.BriefReport)
	 */
	@Override
	public Result<?> reportData() {
		BriefReport subrecord = new BriefReport();// 查询提交总数
		subrecord.setBrStatus(1);
		Integer subCount = briefReportMapper.selectCount(subrecord);

		BriefReport adoptRecord = new BriefReport();// 使用总数
		adoptRecord.setUseStatus(1);
		Integer adoptCount = briefReportMapper.selectCount(adoptRecord);

		List<String> dayList = getHalfYearDay();

		List<Integer> subList = new ArrayList<Integer>();
		List<Integer> adoptList = new ArrayList<Integer>();
		for (String createdAt : dayList) {
			subrecord.setCreatedAt(cn.hutool.core.date.DateUtil.parse(
					createdAt, "yyyy-MM"));
			Integer subNum = briefReportMapper.selectCount(subrecord);
			adoptRecord.setCreatedAt(cn.hutool.core.date.DateUtil.parse(
					createdAt, "yyyy-MM"));
			Integer adoptNum = briefReportMapper.selectCount(adoptRecord);
			subList.add(subNum);
			adoptList.add(adoptNum);
		}
		Map map = new HashMap();
		map.put("totalSub", subCount);
		map.put("totalAdop", adoptCount);
		map.put("month", dayList);
		map.put("subList", subList);
		map.put("adoptList", adoptList);
		return ResultUtil.success(map);
	}

	/**
	 * 
	 * <B>方法名称：getHalfYearDay()</B><BR>
	 * <B>概要说明：获取半年的日期</B><BR>
	 * 
	 * @return
	 */
	private List<String> getHalfYearDay() {
		Integer total = 5;
		List<String> time = new ArrayList<String>();
		Date startDate = new Date();
		for (int i = total; i > 0; i--) {
			startDate = DateUtil.getLastMonth(startDate, i);
			time.add(cn.hutool.core.date.DateUtil.format(startDate, "yyyy-MM"));
		}
		time.add(cn.hutool.core.date.DateUtil.format(new Date(), "yyyy-MM"));
		return time;
	}

	/**
	 * <B>方法名称：</B><BR>
	 * <B>概要说明：</B><BR>
	 * 
	 * @see com.lypz.briefreport.modules.briefreport.service.BriefReportService#reviseExportExcel(java.lang.Integer,
	 *      java.lang.String)
	 */
	@Override
	public Result<?> reviseExportExcel(Integer userId, String filePath) {
		if (StringUtils.isNotBlank(filePath)) {
			File file = new File(filePath);
			if (file.exists()) {
				ExcelWriter writer = ExcelUtil.getWriter(file);
				Integer rows = writer.getRowCount();
				String title = "";
				if (true) {
					title = Constant.AREA_EXCEL_TITLE.replace("XXX", "");
				} else {
					title = Constant.COUNTY_EXCEL_TITLE.replace("XXX", "");
				}
				writer.merge(rows, title, true);
				writer.close();
			}
		}
		return ResultUtil.success(true);
	}

	/**
	 * <B>方法名称：</B><BR>
	 * <B>概要说明：</B><BR>
	 * 
	 * @throws Exception
	 * 
	 * @see com.lypz.briefreport.modules.briefreport.service.BriefReportService#exportExcel(com.lypz.briefreport.modules.briefreport.po.BriefReportPo)
	 */
	@Override
	public void exportExcel(BriefReportPo po, HttpServletResponse response)
			throws Exception {
		OutputStream out = null;
		try {

			String fileName = cn.hutool.core.date.DateUtil.format(new Date(),
					"yyyyMMddHHmmss") + ".xls";
			out = response.getOutputStream();
			response.setContentType("multipart/form-data");
			response.setCharacterEncoding("utf-8");
			response.setHeader("Content-disposition", "attachment;filename="
					+ URLEncoder.encode(fileName, "UTF-8") + ".xls");
			List<BriefReportVo> list = formPageDate(briefReportMapper.page(po));
			ExcelWriter writer = new ExcelWriter(true);
			writer.passCurrentRow();
			// 自定义标题别名
			String[] names = { "id", "title", "author", "unit", "submitType",
					"informatioType", "brStatus", "createdAt" };
			String[] alias = { "序号", "标题", "上报人", "上报单位", "提交类型", "信息类型", "状态",
					"发布时间" };
			for (int i = 0; i < names.length; i++) {
				writer.addHeaderAlias(names[i], alias[i]);
			}
			// 合并单元格后的标题行，使用默认标题样式
			String title = "";
			if (StringUtils.isNotBlank(po.getDeptCode())
					&& po.getDeptCode().length() >= 6) {
				title = Constant.AREA_EXCEL_TITLE.replace("XXX", "");
			} else if (StringUtils.isNotBlank(po.getDeptCode())
					&& po.getDeptCode().length() <= 9) {
				title = Constant.COUNTY_EXCEL_TITLE.replace("XXX", "");
			} else {
				title = "报送表";
			}
			writer.merge(names.length - 1, title);
			// 一次性写出内容，使用默认样式，强制输出标题
			writer.setColumnWidth(names.length - 1, 25);
			writer.write(list, true);
			writer.flush(response.getOutputStream());
			writer.close();
			out.flush();
		} finally {
			if (out != null)
				out.close();
		}
	}
}
