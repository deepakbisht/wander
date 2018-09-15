package com.wander.user;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class WanderUser {

	public static void main(String[] args) {
		SpringApplication.run(WanderUser.class, args);
	}
}
