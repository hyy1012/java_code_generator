package com.netintech.automation;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.thymeleaf.dialect.springdata.SpringDataDialect;


@EnableAutoConfiguration
@SpringBootApplication
@ComponentScan
@EnableJpaRepositories(basePackages = "com.netintech.automation.**.mapper")
@EntityScan(basePackages = "com.netintech.automation.**.bean")
public class AutomationApplication {

	private final static Logger logger = LoggerFactory.getLogger(AutomationApplication.class);

	@Bean
	public SpringDataDialect springDataDialect() {
		return new SpringDataDialect();
	}

	public static void main(String[] args) {
		SpringApplication.run(AutomationApplication.class, args);
	}
}
