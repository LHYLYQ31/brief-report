/**
 * Copyright 2018 LM. All Rights Reserved.
 */
package com.lypz.briefreport.commom.utils;

import com.lypz.briefreport.commom.handle.CRMExceptionEnum;

/**
 * <B>系统名称：mobile-im</B><BR>
 * <B>模块名称：结果数据封装</B><BR>
 * <B>中文类名：</B><BR>
 * <B>概要说明：</B><BR>
 * 
 */
public class ResultUtil {
	/**
	 * 
	 * <B>方法名称：success</B><BR>
	 * <B>概要说明：有参数成功响应</B><BR>
	 *
	 * @author：lihaiyi
	 * @cretetime:2018年7月10日 下午4:58:31
	 * @param obj
	 *            成功结果参数
	 * @return Result
	 */
	public static Result success(Object obj) {
		Result<Object> result = new Result<Object>();
		result.setCode(200);
		result.setMsg("成功");
		result.setData(obj);
		return result;
	}

	/**
	 * 
	 * <B>方法名称：success</B><BR>
	 * <B>概要说明：无参数据成功响应</B><BR>
	 *
	 * @author：lihaiyi
	 * @cretetime:2018年7月10日 下午4:58:35
	 * @return Result
	 */
	public static Result success() {
		return success(null);
	}

	/**
	 * 
	 * <B>方法名称：error</B><BR>
	 * <B>概要说明：错误响应</B><BR>
	 *
	 * @author：lihaiyi
	 * @cretetime:2018年7月10日 下午5:02:02
	 * @param code
	 * @param msg
	 * @return Result
	 */
	public static Result error(Integer code, String msg) {
		Result<Object> result = new Result<Object>();
		result.setCode(code);
		result.setMsg(msg);
		result.setData(null);
		return result;
	}

	public static Result error(CRMExceptionEnum crmEnum) {
		Result<Object> result = new Result<Object>();
		result.setCode(crmEnum.getCode());
		result.setMsg(crmEnum.getMsg());
		result.setData(null);
		return result;
	}
}
