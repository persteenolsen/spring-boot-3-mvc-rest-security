package com.persteenolsen.springbootrestjpalogin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.*;


@SpringBootApplication
public class SpringBootRestJpaLoginApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootRestJpaLoginApplication.class, args);
	}

	
    // Ready for builing a war file used for Tomcat
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(SpringBootRestJpaLoginApplication.class);
	}

}
