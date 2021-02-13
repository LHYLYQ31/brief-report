/**
 * Copyright 2018 LM. All Rights Reserved.
 */
package com.lypz.briefreport.commom.utils;

/**
 * 
 * <B>系统名称：</B><BR>
 * <B>模块名称：</B><BR>
 * <B>中文类名：</B><BR>
 * <B>概要说明：</B><BR>
 * 
 * @author 枫林雪山 @lhy
 * @since 2020年11月4日
 */
public class ResultUtil {
	/**
	 * 
	 * <B>方法名称：</B><BR>
	 * <B>概要说明：</B><BR>
	 * 
	 * @param obj
	 * @return
	 */
	public static Result success(Object obj) {
		Result<Object> result = new Result<Object>();
		result.setCode(10000);
		result.setMsg("成功");
		result.setData(obj);
		result.setStatus(10000);
		return result;
	}

	/**
	 * 
	 * <B>方法名称：</B><BR>
	 * <B>概要说明：</B><BR>
	 * 
	 * @param code
	 * @param status
	 * @param msg
	 * @return
	 */

	public static Result success(Integer code, Integer status, String msg) {
		Result<Object> result = new Result<Object>();
		result.setCode(code);
		result.setMsg(msg);
		result.setData(null);
		result.setStatus(status);
		return result;
	}

	public static Result success(Integer code, Integer status, String msg,
			Object obj) {
		Result<Object> result = new Result<Object>();
		result.setCode(code);
		result.setMsg(msg);
		result.setData(obj);
		result.setStatus(status);
		return result;
	}

	/**
	 * 
	 * <B>方法名称：</B><BR>
	 * <B>概要说明：</B><BR>
	 * 
	 * @param code
	 * @param status
	 * @param msg
	 * @return
	 */
	public static Result error(Integer code, Integer status, String msg) {
		Result<Object> result = new Result<Object>();
		result.setCode(code);
		result.setMsg(msg);
		result.setData(null);
		result.setStatus(status);
		return result;
	}

	/**
	 * 
	 * <B>方法名称：</B><BR>
	 * <B>概要说明：</B><BR>
	 * 
	 * @param code
	 * @param status
	 * @param msg
	 * @param errorInfo
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	public static Result error(Integer code, Integer status, String msg,
			String errorInfo) {
		Result<Object> result = new Result<Object>();
		result.setCode(code);
		result.setMsg(msg);
		result.setData(null);
		result.setStatus(status);
		result.setErrorInfo(errorInfo);
		return result;
	}
}
