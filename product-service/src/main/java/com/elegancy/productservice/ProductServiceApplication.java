package com.elegancy.productservice;

import com.elegancy.productservice.dto.ProductRequestDTO;
import com.elegancy.productservice.service.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ProductServiceApplication /*implements CommandLineRunner*/ {

	public static void main(String[] args) {
		SpringApplication.run(ProductServiceApplication.class, args);
	}

	/*@Autowired
	private ProductServiceImpl productService;
	@Override
	public void run(String... args) throws Exception {

		productService.saveProduct(new ProductRequestDTO(null, "Marguerita", 2500,40));
		productService.saveProduct(new ProductRequestDTO(null, "Bordeaux", 3500,20));

	}*/
}
