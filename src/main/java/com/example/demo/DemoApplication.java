package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.Banner.Mode;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class DemoApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		//正常启动
		//SpringApplication.run(SpringbootOneApplication.class, args);
		
		//自定义启动
        SpringApplication application = new SpringApplication(DemoApplication.class);
        application.setBannerMode(Mode.OFF); //关闭banner（logo）
        application.run(args);
	}

	//重写SpringBootServletInitializer中的configure，功效等同于web.xml
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(DemoApplication.class);
	}

}
