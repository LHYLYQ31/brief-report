/**
 * Copyright 2021 SinoSoft. All Rights Reserved.
 */
package com.lypz.briefreport.config;

import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.lypz.briefreport.commom.filter.AppInterceptor;

/**
 * <B>系统名称：</B><BR>
 * <B>模块名称：</B><BR>
 * <B>中文类名：</B><BR>
 * <B>概要说明：</B><BR>
 * @author 枫林雪山 @lhy
 * @since 2021年2月13日
 */
/**
 * @Author: Eric
 **/
// @SuppressWarnings("deprecation")
// @Configuration
public class WebMvcConfig implements WebMvcConfigurer {

	private static final String[] CLASSPATH_RESOURCE_LOCATIONS = {
			"classpath:/META-INF/resources/", "classpath:/resources/",
			"classpath:/static/", "classpath:/public/" };

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(new AppInterceptor()).addPathPatterns("/**")
				.excludePathPatterns("");
	}

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		// 配置server虚拟路径，handler为页面中访问的目录，locations为files相对应的本地路径
		registry.addResourceHandler("/static/**").addResourceLocations(
				CLASSPATH_RESOURCE_LOCATIONS);
	}

}
