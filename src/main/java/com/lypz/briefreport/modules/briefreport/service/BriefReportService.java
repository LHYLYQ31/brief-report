/**
 * Copyright 2021 SinoSoft. All Rights Reserved.
 */
package com.lypz.briefreport.modules.briefreport.service;

import com.alibaba.fastjson.JSONObject;
import com.lypz.briefreport.commom.utils.Result;
import com.lypz.briefreport.modules.briefreport.po.BriefReportPo;

/**
 * <B>系统名称：</B><BR>
 * <B>模块名称：</B><BR>
 * <B>中文类名：</B><BR>
 * <B>概要说明：</B><BR>
 * 
 * @author 枫林雪山 @lhy
 * @since 2021年2月13日
 */
public interface BriefReportService {

	Result<?> detail(Integer id);

	/**
	 * 
	 * <B>方法名称：page</B><BR>
	 * <B>概要说明：分页查询简报数据</B><BR>
	 * 
	 * @param po
	 * @return
	 */
	Result<?> page(BriefReportPo po);

	/**
	 *
	 * <B>方法名称：save</B><BR>
	 * <B>概要说明：保存简报信息</B><BR>
	 *
	 * @param jsonObject
	 *            简报信息
	 * @return int 结果值
	 */
	int save(JSONObject jsonObject);

	/**
	 *
	 * <B>方法名称：update</B><BR>
	 * <B>概要说明：更新简报信息</B><BR>
	 *
	 * @param jsonObject
	 *            简报信息
	 * @return int 结果值
	 */
	int update(JSONObject jsonObject);

	/**
	 *
	 * <B>方法名称：delete</B><BR>
	 * <B>概要说明：删除简报信息</B><BR>
	 *
	 * @param jsonObject
	 *            简报信息
	 * @return int 结果值
	 */
	int delete(JSONObject jsonObject);
}
