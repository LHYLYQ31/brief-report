/**
 * Copyright 2021 SinoSoft. All Rights Reserved.
 */
package com.lypz.briefreport.modules.briefreport.vo;

import java.util.List;

import com.lypz.briefreport.modules.attachment.model.Attachment;
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
public class BriefReportDetailVo extends BriefReport {

	private List<Attachment> attachments;

	/**
	 * <B>取得：</B>attachments<BR>
	 * 
	 * @return List<Attachment>
	 */
	public List<Attachment> getAttachments() {
		return attachments;
	}

	/**
	 * <B>设定：</B>attachments<BR>
	 * 
	 * @param attachments
	 */
	public void setAttachments(List<Attachment> attachments) {
		this.attachments = attachments;
	}

}
