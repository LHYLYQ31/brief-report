package com.lypz.briefreport;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
@EnableAutoConfiguration
@MapperScan(basePackages = { "com.lypz.briefreport.modules.*.dao" })
@ServletComponentScan
// @EnableAspectJAutoProxy
public class BriefReportApplication {

	public static void main(String[] args) {
		SpringApplication.run(BriefReportApplication.class, args);
	}

}
