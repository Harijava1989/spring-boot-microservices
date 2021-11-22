package com.javacodegeeks.example.rest.multiplication;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;

import java.util.logging.Logger;

@EnableAutoConfiguration
@EnableDiscoveryClient
@ComponentScan
public class MultiplicationServer {

	protected Logger logger = Logger.getLogger(MultiplicationServer.class.getName());

	public static void main(String[] args) {
		System.setProperty("spring.config.name", "multiplication-server");

		SpringApplication.run(MultiplicationServer.class, args);
	}
}
