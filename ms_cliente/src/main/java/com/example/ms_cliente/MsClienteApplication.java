package com.example.ms_cliente;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class MsClienteApplication {
	public static void main(String[] args) {
		SpringApplication.run(MsClienteApplication.class, args);
	}
}