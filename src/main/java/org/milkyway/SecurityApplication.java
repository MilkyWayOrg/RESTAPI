package org.milkyway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.RequestMapping;

@SpringBootApplication

public class SecurityApplication extends SpringBootServletInitializer{ // extending to run Spring Boot applications from a classical WAR archive.
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(SecurityApplication.class);
	}
	public static void main(String[] args) {
		System.setProperty("server.servlet.context-path", "/rest");
		SpringApplication.run(SecurityApplication.class, args);
	}
}

