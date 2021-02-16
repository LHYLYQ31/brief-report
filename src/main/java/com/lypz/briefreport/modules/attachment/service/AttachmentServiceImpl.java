/**
 * Copyright 2021 SinoSoft. All Rights Reserved.
 */
package com.lypz.briefreport.modules.attachment.service;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import cn.hutool.core.date.DateUtil;

import com.lypz.briefreport.commom.handle.CRMException;
import com.lypz.briefreport.commom.handle.CRMExceptionEnum;
import com.lypz.briefreport.commom.utils.Result;
import com.lypz.briefreport.commom.utils.ResultUtil;
import com.lypz.briefreport.modules.attachment.dao.AttachmentMapper;
import com.lypz.briefreport.modules.attachment.model.Attachment;
import com.lypz.briefreport.modules.briefreport.dao.BriefReportMapper;
import com.lypz.briefreport.modules.briefreport.model.BriefReport;

/**
 * <B>系统名称：</B><BR>
 * <B>模块名称：</B><BR>
 * <B>中文类名：</B><BR>
 * <B>概要说明：</B><BR>
 * 
 * @author 枫林雪山 @lhy
 * @since 2021年2月15日
 */
@Service
@Transactional
public class AttachmentServiceImpl implements AttachmentService {
	@Resource
	AttachmentMapper attachmentMapper;
	@Resource
	BriefReportMapper briefReportMapper;
	@Value("${brie.freport.path}")
	String brieFreportPath;

	/**
	 * <B>方法名称：</B><BR>
	 * <B>概要说明：</B><BR>
	 * 
	 * @see com.lypz.briefreport.modules.attachment.service.AttachmentService#list(com.lypz.briefreport.modules.attachment.model.Attachment)
	 */
	@Override
	public List<Attachment> list(Attachment att) {
		// TODO Auto-generated method stub
		return attachmentMapper.select(att);
	}

	/**
	 * <B>方法名称：</B><BR>
	 * <B>概要说明：</B><BR>
	 * 
	 * @see com.lypz.briefreport.modules.attachment.service.AttachmentService#list(java.lang.Integer)
	 */
	@Override
	public List<Attachment> list(Integer businessType) {
		Attachment att = new Attachment();
		att.setBusinessType(businessType);
		return this.list(att);
	}

	/**
	 * <B>方法名称：</B><BR>
	 * <B>概要说明：</B><BR>
	 * 
	 * @see com.lypz.briefreport.modules.attachment.service.AttachmentService#delete(java.lang.Integer)
	 */
	@Override
	public Result<?> delete(Integer id, Integer userId) {
		Attachment satt = attachmentMapper.selectById(id);
		Integer autherId = null;
		if (satt != null) {
			if (satt.getBusinessType() == 1) {
				BriefReport sbr = briefReportMapper.selectById(Integer
						.parseInt(satt.getBusinessId()));
				if (sbr != null) {
					autherId = sbr.getUserId();
				}

			}
			if (!userId.equals(autherId)) {
				throw new CRMException(CRMExceptionEnum.NO_POWER_ERROR);
			}

		}
		Attachment att = new Attachment();
		att.setId(id);
		att.setDeletedAt(new Date());
		att.setIsDeleted("0");
		int result = attachmentMapper.update(att);
		if (result == 1) {
			return ResultUtil.success(true);
		} else {
			return ResultUtil.success(false);
		}
	}

	@Override
	public Result upload(MultipartFile[] files, HttpServletRequest request)
			throws Exception {
		try {
			String type = request.getParameter("businessType");
			String businessId = request.getParameter("businessId");
			if (files == null || StringUtils.isBlank(type)) {
				throw new CRMException(CRMExceptionEnum.PARAM_EMPTY);
			}
			List<Integer> ids = new ArrayList<Integer>();
			List<Attachment> attachments = new ArrayList<Attachment>();
			for (int i = 0; i < files.length; i++) {
				MultipartFile mfile = files[i];
				if (!mfile.isEmpty()) {
					String fileName = mfile.getOriginalFilename();
					String fileExt = fileName.substring(
							fileName.lastIndexOf(".") + 1).toLowerCase();
					Attachment attachment = new Attachment();
					attachment.setFileName(fileName);
					attachment.setBusinessId(businessId);
					attachment.setBusinessType(Integer.parseInt(type));
					attachment.setCreatedAt(new Date());
					String tempPath = File.separator
							+ DateUtil.format(new Date(), "yyyy-MM-dd")
							+ File.separator + UUID.randomUUID().toString()
							+ "." + fileExt;
					attachment.setFilePath(tempPath);
					File file = new File(brieFreportPath + tempPath);
					if (!file.exists()) {
						if (file.getParentFile().exists()) {
							file.createNewFile();
						} else {
							file.getParentFile().mkdirs();
							file.createNewFile();
						}
					}
					mfile.transferTo(file);
					this.save(attachment);
					ids.add(attachment.getId());
					attachments.add(attachment);
				}

			}
			Map map = new HashMap();
			map.put("ids", ids);
			map.put("attachments", attachments);
			return ResultUtil.success(map);
		} finally {

		}
	}

	public void save(Attachment att) {
		att.setCreatedAt(new Date());
		att.setIsDeleted("1");
		int result = attachmentMapper.insert(att);

	}

	/**
	 * <B>方法名称：</B><BR>
	 * <B>概要说明：</B><BR>
	 * 
	 * @see com.lypz.briefreport.modules.attachment.service.AttachmentService#update(com.lypz.briefreport.modules.attachment.model.Attachment)
	 */
	@Override
	public Boolean update(Attachment att) {
		att.setUpdatedAt(new Date());
		Integer result = attachmentMapper.update(att);
		if (result == 1) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * <B>方法名称：</B><BR>
	 * <B>概要说明：</B><BR>
	 * 
	 * @see com.lypz.briefreport.modules.attachment.service.AttachmentService#update(java.util.List,
	 *      java.lang.Integer)
	 */
	@Override
	public Boolean update(String[] ids, Integer businessId) {
		if (ids != null)
			for (String id : ids) {
				if (StringUtils.isNotBlank(id)) {
					Attachment att = new Attachment();
					att.setId(Integer.parseInt(id));
					att.setBusinessId(businessId.toString());
					this.update(att);
				}

			}
		return true;
	}
}
