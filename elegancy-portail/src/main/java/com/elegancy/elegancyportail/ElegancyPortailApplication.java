package com.elegancy.elegancyportail;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients(value = "com.elegancy")
public class ElegancyPortailApplication {

	public static void main(String[] args) {
		SpringApplication.run(ElegancyPortailApplication.class, args);
	}

}
