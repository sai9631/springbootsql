package com.boot.microservice.sql.demo.springbootsql;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableDiscoveryClient
@SpringBootApplication
@EnableJpaRepositories
public class SpringbootsqlApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootsqlApplication.class, args);
	}
}
