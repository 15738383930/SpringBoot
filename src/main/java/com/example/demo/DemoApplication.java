package com.example.demo;

import org.springframework.boot.Banner.Mode;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

/**
 * 项目启动类
 * 1. 因项目用到redis数据库，且没有配置该数据源（没必要），故，排除DataSourceAutoConfiguration.class
 * 2. 因项目需要打war包（已排除内嵌Tomcat）进行平台移植发布，故，继承SpringBootServletInitializer类，实现等同于web.xml的功能
 * @author zhou
 *
 */
@SpringBootApplication(exclude =DataSourceAutoConfiguration.class )
public class DemoApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		// 自定义启动
        SpringApplication application = new SpringApplication(DemoApplication.class);
		// 关闭banner（logo）
        application.setBannerMode(Mode.OFF);
        application.run(args);
	}

	/**
	 * 重写SpringBootServletInitializer中的configure，功效等同于web.xml
	 * @param builder
	 * @return
	 */
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(DemoApplication.class);
	}

}
