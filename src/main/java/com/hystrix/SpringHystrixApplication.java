package com.hystrix;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;

@EnableHystrix
@SpringBootApplication
public class SpringHystrixApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringHystrixApplication.class, args);
	}

}
