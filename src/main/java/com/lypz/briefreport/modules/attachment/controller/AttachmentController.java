/**
 * Copyright 2021 SinoSoft. All Rights Reserved.
 */
package com.lypz.briefreport.modules.attachment.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.lypz.briefreport.commom.utils.LoginUtil;
import com.lypz.briefreport.commom.utils.Result;
import com.lypz.briefreport.commom.utils.ResultUtil;
import com.lypz.briefreport.modules.attachment.model.Attachment;
import com.lypz.briefreport.modules.attachment.service.AttachmentService;

/**
 * <B>系统名称：</B><BR>
 * <B>模块名称：</B><BR>
 * <B>中文类名：</B><BR>
 * <B>概要说明：</B><BR>
 * 
 * @author 枫林雪山 @lhy
 * @since 2021年2月16日
 */
@RestController
@RequestMapping("attachment")
public class AttachmentController {
	@Autowired
	AttachmentService attachmentService;

	/**
	 * 
	 * <B>方法名称：delete</B><BR>
	 * <B>概要说明：根据id删除附件</B><BR>
	 * 
	 * @param id
	 * @return
	 */
	@PostMapping("delete/{id}")
	Result<?> delete(@PathVariable Integer id, HttpServletRequest request) {
		return attachmentService.delete(id,
				Integer.parseInt(LoginUtil.getLoginUserId(request)));
	}

	/**
	 * 
	 * <B>方法名称：list</B><BR>
	 * <B>概要说明：查询对应条件的附件</B><BR>
	 * 
	 * @param att
	 * @return
	 */
	@GetMapping("list")
	Result<?> list(Attachment att) {
		if (StringUtils.isBlank(att.getBusinessId())
				|| att.getBusinessType() == null || att.getBusinessType() == 0) {
			return ResultUtil.success(new ArrayList<Attachment>());
		}
		return ResultUtil.success(attachmentService.list(att));
	}

	@RequestMapping("upload")
	Result<?> upload(MultipartFile[] files, HttpServletRequest request)
			throws Exception {
		return attachmentService.upload(files, request);
	}

}
