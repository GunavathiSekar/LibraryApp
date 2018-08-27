package com.kg.boook;

import org.h2.server.web.WebServlet;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class BoookApplication {

	public static void main(String[] args) {
		SpringApplication.run(BoookApplication.class, args);
	}
	
@Bean
	public ServletRegistrationBean h2servletRegistration() {
		ServletRegistrationBean registration = new ServletRegistrationBean(new WebServlet());
		String string = "/db/*";
		registration.addUrlMappings(string);
		return registration;
	}
}

