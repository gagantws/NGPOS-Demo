package com.demo.inventory;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableDiscoveryClient // Activates Eureka Client
@EnableFeignClients    // Activates OpenFeign
@SpringBootApplication
public class InventoryApplication {

	public static void main(String[] args) {
		SpringApplication.run(InventoryApplication.class, args);
	}

}
