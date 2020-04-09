package com.kiran.test4;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

import com.kiran.test4.repositories.UserRepository;

@SpringBootApplication(exclude= HibernateJpaAutoConfiguration.class)
public class Test4Application extends SpringBootServletInitializer{
	
	@Autowired
	private UserRepository userRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(Test4Application.class, args);
		System.out.println("Hello World");
	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(Test4Application.class);
	}
}
