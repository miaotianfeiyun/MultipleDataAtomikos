package com.oojunzi.test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;
@EnableAutoConfiguration
@Configuration
@EnableTransactionManagement(proxyTargetClass = true)
@SpringBootApplication
public class TestdataApplication {
	public static void main(String[] args) {
		SpringApplication.run(TestdataApplication.class, args);
	}
}
