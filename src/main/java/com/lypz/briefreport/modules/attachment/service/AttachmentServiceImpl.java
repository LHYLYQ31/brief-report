/**
 * Copyright 2021 SinoSoft. All Rights Reserved.
 */
package com.lypz.briefreport.modules.attachment.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.lypz.briefreport.modules.attachment.dao.AttachmentMapper;
import com.lypz.briefreport.modules.attachment.model.Attachment;

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
public class AttachmentServiceImpl implements AttachmentService {
	@Resource
	AttachmentMapper attachmentMapper;

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
}
