/**
 * Copyright 2018 LM. All Rights Reserved.
 */
package com.lypz.briefreport.commom.handle;

/**
 * <B>系统名称：</B><BR>
 * <B>模块名称：</B><BR>
 * <B>中文类名：</B><BR>
 * <B>概要说明：</B><BR>
 * 
 */
public class CRMException extends RuntimeException {
	private Integer code;

	/**
	 * <B>构造方法</B><BR>
	 * 
	 * @param code
	 */
	public CRMException(CRMExceptionEnum lmEnum) {
		super(lmEnum.getMsg());
		this.code = lmEnum.getCode();
	}

	/**
	 * <B>构造方法</B><BR>
	 * 
	 * @param code
	 */
	public CRMException(Integer code, String message) {
		super(message);
		this.code = code;
	}

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}
}
