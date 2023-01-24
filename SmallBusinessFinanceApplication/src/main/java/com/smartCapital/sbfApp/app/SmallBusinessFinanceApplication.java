package com.smartCapital.sbfApp.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@ComponentScan
@EnableJpaRepositories
@SpringBootApplication
public class SmallBusinessFinanceApplication {

	public static void main(String[] args) {
		SpringApplication.run(SmallBusinessFinanceApplication.class, args);
	}

}
