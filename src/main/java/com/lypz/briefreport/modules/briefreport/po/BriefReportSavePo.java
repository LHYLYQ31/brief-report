/**
 * Copyright 2021 SinoSoft. All Rights Reserved.
 */
package com.lypz.briefreport.modules.briefreport.po;

import com.lypz.briefreport.modules.briefreport.model.BriefReport;

/**
 * <B>系统名称：</B><BR>
 * <B>模块名称：</B><BR>
 * <B>中文类名：</B><BR>
 * <B>概要说明：</B><BR>
 * 
 * @author 枫林雪山 @lhy
 * @since 2021年2月16日
 */
public class BriefReportSavePo extends BriefReport {
	public String attachmentIds;

	/**
	 * <B>取得：</B>attachmentIds<BR>
	 * 
	 * @return List<Integer>
	 */
	public String getAttachmentIds() {
		return attachmentIds;
	}

	/**
	 * <B>设定：</B>attachmentIds<BR>
	 * 
	 * @param attachmentIds
	 */
	public void setAttachmentIds(String attachmentIds) {
		this.attachmentIds = attachmentIds;
	}

}
