/**
 * Copyright 2018 LM. All Rights Reserved.
 */
package com.lypz.briefreport.commom.handle;

/**
 * <B>系统名称：mobile-im</B><BR>
 * <B>模块名称：异常枚举</B><BR>
 * <B>中文类名：</B><BR>
 * <B>概要说明：</B><BR>
 * 
 */
public enum CRMExceptionEnum {
	UNKNOWN_ERROR(-1, "未知错误"), PARAM_EMPTY(-2, "参数为空"), WRONGFUL_ERROR(-3,
			"参数不合法"), DB_EMPTY(-6, "数据库中的字段值为空"), JSON_FORM_ERROR(-4,
			"json数据格式不符合标准"), FILE_NO_EXIST(-5, "文件不存在"), CODE_TIMEOUT(-1,
			"未知错误"), LOGIN_FAIL(-2, "参数为空"), EMAIL_NO_AUTH(-3, "参数不合法"), MOBILE_NO_AUTH(
			-6, "数据库中的字段值为空"), FILE_TYPE_ERROR(-7, "文件类型错误"), REPEAT_MEMBERID_ERROR(
			-8, "修改的会员编号已经存在"), LOGIN_LOSE_EFFICACY_ERROR(-9, "登录失效");
	private Integer code;

	private String msg;

	/**
	 * <B>构造方法</B><BR>
	 * 
	 * @param code
	 * @param msg
	 */
	private CRMExceptionEnum(Integer code, String msg) {
		this.code = code;
		this.msg = msg;
	}

	public Integer getCode() {
		return code;
	}

	public String getMsg() {
		return msg;
	}

}
