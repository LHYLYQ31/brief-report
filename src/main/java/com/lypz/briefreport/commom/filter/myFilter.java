/**
 * Copyright 2019 SinoSoft. All Rights Reserved.
 */
package com.lypz.briefreport.commom.filter;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.net.URLDecoder;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.lypz.briefreport.commom.handle.ExceptionHandle;

/**
 * <B>系统名称：</B><BR>
 * <B>模块名称：</B><BR>
 * <B>中文类名：</B><BR>
 * <B>概要说明：</B><BR>
 * 
 * @author lypz-lihaiyi
 * @since 2019年11月29日
 */
//
@WebFilter(filterName = "myFilter", urlPatterns = "/*", initParams = {})
public class myFilter implements Filter {
	private static final Logger logger = LoggerFactory
			.getLogger(ExceptionHandle.class);

	/**
	 * <B>方法名称：</B><BR>
	 * <B>概要说明：</B><BR>
	 * 
	 * @see javax.servlet.Filter#init(javax.servlet.FilterConfig)
	 */

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {

	}

	/**
	 * <B>方法名称：</B><BR>
	 * <B>概要说明：</B><BR>
	 * 
	 * @see javax.servlet.Filter#doFilter(javax.servlet.ServletRequest,
	 *      javax.servlet.ServletResponse, javax.servlet.FilterChain)
	 */

	@Override
	public void doFilter(ServletRequest req, ServletResponse res,
			FilterChain chain) {
		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) res;
		// 设置跨域
		this.allowOrigin(response);
		request.getSession()
				.setAttribute("userId", request.getHeader("userId"));
		// request.getSession().setAttribute("userUUId",
		// "de95fd45-9ab6-4a9a-8dc4-c526e3285e5b");
		request.getSession()
				.setAttribute("code", request.getHeader("deptCode"));

		request.getSession().setAttribute("organizationName",
				request.getHeader("organizationName"));

		request.getSession().setAttribute(
				"loginName",
				request.getHeader("loginName") == null ? "" : URLDecoder
						.decode(request.getHeader("loginName").toString()));
		// CookieUtils.setCookie("userId", "1", response);
		// CookieUtils.setCookie("userId",
		// "de95fd45-9ab6-4a9a-8dc4-c526e3285e5b",
		// response);
		// CookieUtils.setCookie("code", "001001", response);
		// System.out.println(CookieUtils.getCookie("code",
		// request).getValue());
		try {

			chain.doFilter(request, response);
			// HttpServletResponseWrapper httpResponse = new
			// HttpServletResponseWrapper(
			// response);
			// String path = request.getServletPath();// 请求路径
			// path = path.replace("/mq-pay-dev", "");
			// path = path.replace("/mq-pay-pre", "");
			// path = path.replace("/mq-pay", "");
			// request.getRequestDispatcher(path).forward(request, response);

		} catch (Exception e) {
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			e.printStackTrace(new PrintStream(baos));
			String exception = baos.toString();
			logger.error("系统报错信息：{}", exception);

		}

	}

	/**
	 * <B>方法名称：</B><BR>
	 * <B>概要说明：</B><BR>
	 * 
	 * @see javax.servlet.Filter#destroy()
	 */
	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	/**
	 * 
	 * <B>方法名称：allowOrigin</B><BR>
	 * <B>概要说明：设置跨域</B><BR>
	 *
	 * @author：lihaiyi
	 * @cretetime:2020年8月31日 下午2:49:42
	 * @param response
	 *            void
	 */
	private void allowOrigin(HttpServletResponse response) {
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.setHeader("Access-Control-Allow-Methods",
				"POST, GET, OPTIONS, DELETE");
		response.setHeader("Access-Control-Max-Age", "0");
		response.setHeader("Access-Control-Allow-Headers", "*");
		// response.setHeader(
		// "Access-Control-Allow-Headers",
		// "Origin, No-Cache, X-Requested-With, If-Modified-Since, Pragma, Last-Modified,"
		// +
		// " Cache-Control, Expires,Content-Type, X-E4M-With,userId,token,Authorization,"
		// + "authorization,platform,source,mobile,device,User-Agent");
		response.setHeader("Access-Control-Allow-Credentials", "true");
		response.setHeader("XDomainRequestAllowed", "1");
	}

	private static String getPostData(HttpServletRequest request) {
		StringBuffer data = new StringBuffer();
		String line = null;
		BufferedReader reader = null;
		try {
			reader = request.getReader();
			while (null != (line = reader.readLine()))
				data.append(line);
		} catch (IOException e) {
		} finally {
		}
		return data.toString();
	}
}
