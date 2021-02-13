/**
 * Copyright 2021 SinoSoft. All Rights Reserved.
 */
package com.lypz.briefreport.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

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
@Configuration
public class WebMvcConfig extends WebMvcConfigurationSupport {

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		// 将templates目录下的CSS、JS文件映射为静态资源，防止Spring把这些资源识别成thymeleaf模版
		registry.addResourceHandler("/templates/**.js").addResourceLocations(
				"classpath:/templates/");
		registry.addResourceHandler("/templates/**.css").addResourceLocations(
				"classpath:/templates/");
		// 其他静态资源
		registry.addResourceHandler("/static/**").addResourceLocations(
				"classpath:/static/");
	}
}
