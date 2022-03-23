package com.kafkaExample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import lombok.extern.slf4j.Slf4j;

@SpringBootApplication
@Slf4j
public class SpringKafkaUserApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringKafkaUserApplication.class, args);
		log.info("Springboot and kafka application is started successfully.");
	}

}
