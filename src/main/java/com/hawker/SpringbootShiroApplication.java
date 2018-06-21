package com.hawker;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
//@EnableEurekaClient
@MapperScan(basePackages = "com.hawker.mapper")
public class SpringbootShiroApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootShiroApplication.class, args);
	}
}
