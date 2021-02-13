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
 * 
 * <B>系统名称：</B><BR>
 * <B>模块名称：</B><BR>
 * <B>中文类名：</B><BR>
 * <B>概要说明：</B><BR>
 * 
 * @author 枫林雪山 @lhy
 * @since 2020年11月2日
 */
@ControllerAdvice
public class ExceptionHandle {

	private static final Logger logger = LoggerFactory
			.getLogger(ExceptionHandle.class);

	/**
	 * 
	 * <B>方法名称：</B><BR>
	 * <B>概要说明：</B><BR>
	 * 
	 * @param e
	 * @return
	 */
	@ResponseBody
	@ExceptionHandler(value = Exception.class)
	public Result handle(Exception e) {
		if (e instanceof LMWebException) {
			LMWebException ime = (LMWebException) e;
			if (ime.getCode() == null || ime.getStatus() == null) {
				return ResultUtil.success(ime.getData());
			} else {
				return ResultUtil.error(ime.getCode(), ime.getStatus(),
						ime.getMessage());
			}

		} else if (e instanceof RuntimeException) {
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			e.printStackTrace(new PrintStream(baos));
			String exception = baos.toString();
			logger.error("业务逻辑报错：{}", exception);
			return ResultUtil.error(
					LMWebExceptionEnum.BUSINESS_ERROR.getCode(),
					LMWebExceptionEnum.BUSINESS_ERROR.getStatus(),
					LMWebExceptionEnum.BUSINESS_ERROR.getMsg(), exception);
		} else {
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			e.printStackTrace(new PrintStream(baos));
			String exception = baos.toString();
			logger.error("系统报错信息：{}", exception);
			return ResultUtil.error(LMWebExceptionEnum.UNKNOWN_ERROR.getCode(),
					LMWebExceptionEnum.UNKNOWN_ERROR.getStatus(),
					LMWebExceptionEnum.UNKNOWN_ERROR.getMsg(), exception);
		}
	}

}
