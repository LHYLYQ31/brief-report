/**
 * Copyright 2018 LM. All Rights Reserved.
 */
package com.lypz.briefreport.commom.handle;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lypz.briefreport.commom.utils.Result;
import com.lypz.briefreport.commom.utils.ResultUtil;

/**
 * <B>系统名称：tr</B><BR>
 * <B>模块名称：统一异常处理</B><BR>
 * <B>中文类名：</B><BR>
 * <B>概要说明：</B><BR>
 * 
 * @since 2018年7月10日
 */
@ControllerAdvice
public class ExceptionHandle {
	private static final Logger logger = LoggerFactory
			.getLogger(ExceptionHandle.class);

	/**
	 * 
	 * <B>方法名称：handle</B><BR>
	 * <B>概要说明：统一处理异常</B><BR>
	 *
	 * @author：lihaiyi
	 * @cretetime:2018年7月10日 下午5:16:15
	 * @param e
	 * @return Result
	 */
	@ResponseBody
	@ExceptionHandler(value = Exception.class)
	public Result handle(Exception e) {
		if (e instanceof CRMException) {
			// 自定义异常
			CRMException ime = (CRMException) e;
			return ResultUtil.error(ime.getCode(), ime.getMessage());
		} else {
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			e.printStackTrace(new PrintStream(baos));
			String exception = baos.toString();
			logger.error("系统报错信息：{}", exception);
			return ResultUtil.error(CRMExceptionEnum.UNKNOWN_ERROR.getCode(),
					exception);
		}
	}
}
