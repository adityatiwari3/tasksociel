package com.aadi.sociel;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
public class SocielApplication {

	public static void main(String[] args) {
		SpringApplication.run(SocielApplication.class, args);
		System.out.println("server stated");
	}
}
