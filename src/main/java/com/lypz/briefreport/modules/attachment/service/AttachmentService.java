/**
 * Copyright 2021 SinoSoft. All Rights Reserved.
 */
package com.lypz.briefreport.modules.attachment.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.multipart.MultipartFile;

import com.lypz.briefreport.commom.utils.Result;
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
public interface AttachmentService {

	/**
	 * 
	 * <B>方法名称：list</B><BR>
	 * <B>概要说明：查询对应条件的附件</B><BR>
	 * 
	 * @param att
	 * @return
	 */
	List<Attachment> list(Attachment att);

	/**
	 * 
	 * <B>方法名称：list</B><BR>
	 * <B>概要说明：查询对应条件的附件</B><BR>
	 * 
	 * @param businessType
	 *            业务类型
	 * @return
	 */
	List<Attachment> list(Integer businessType);

	/**
	 * 
	 * <B>方法名称：delete</B><BR>
	 * <B>概要说明：根据id删除附件</B><BR>
	 * 
	 * @param id
	 * @return
	 */
	Result<?> delete(Integer id);

	/**
	 * 
	 * <B>方法名称：</B><BR>
	 * <B>概要说明：</B><BR>
	 * 
	 * @param att
	 */
	Boolean update(Attachment att);

	Boolean update(String[] ids, Integer businessId);

	/**
	 * 
	 * <B>方法名称：上传文件</B><BR>
	 * <B>概要说明：</B><BR>
	 * 
	 * @param files
	 *            文件
	 * @param request
	 * @return
	 * @throws Exception
	 */

	public Result upload(MultipartFile[] files, HttpServletRequest request)
			throws Exception;

}
