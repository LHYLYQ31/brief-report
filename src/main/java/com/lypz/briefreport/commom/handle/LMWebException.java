/**
 * Copyright 2018 LM. All Rights Reserved.
 */
package com.lypz.briefreport.commom.handle;

/**
 * 
 * <B>系统名称：</B><BR>
 * <B>模块名称：</B><BR>
 * <B>中文类名：</B><BR>
 * <B>概要说明：</B><BR>
 * 
 * @author 枫林雪山 @lhy
 * @since 2020年11月2日
 */
public class LMWebException extends RuntimeException {
	private Integer code;

	private Integer status;
	private Object data;

	/**
	 * <B>构�?�方�?</B><BR>
	 * 
	 * @param data
	 */
	public LMWebException(Object data) {
		super();
		this.data = data;
	}

	/**
	 * <B>取得�?</B>data<BR>
	 * 
	 * @return Object
	 */
	public Object getData() {
		return data;
	}

	/**
	 * <B>设定�?</B>data<BR>
	 * 
	 * @param data
	 */
	public void setData(Object data) {
		this.data = data;
	}

	/**
	 * <B>构�?�方�?</B><BR>
	 * 
	 * @param code
	 */
	public LMWebException(LMWebExceptionEnum lmEnum) {
		super(lmEnum.getMsg());
		this.code = lmEnum.getCode();
		this.status = lmEnum.getStatus();
	}

	/**
	 * <B>构�?�方�?</B><BR>
	 * 
	 * @param code
	 */
	public LMWebException(Integer code, Integer status, String message) {
		super(message);
		this.code = code;
		this.status = status;
	}

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

}
