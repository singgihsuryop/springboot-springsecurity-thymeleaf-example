package com.singgihsuryop.springboot.springsecurity;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;


@SpringBootApplication(scanBasePackages="com.singgihsuryop.springboot.springsecurity.httpbasic")
//@ComponentScan({"com.singgihsuryop", "com.ssp"})
public class Application extends SpringBootServletInitializer {
	private static Class<Application> entryPointClass = Application.class;
	
    public static void main(String[] args) {
        SpringApplication.run(entryPointClass, args);
    }
    
    @Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(Application.class);
	}
}
