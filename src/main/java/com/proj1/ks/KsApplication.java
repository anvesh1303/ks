package com.proj1.ks;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = { SecurityAutoConfiguration.class})
public class KsApplication {

	public static void main(String[] args) {
		SpringApplication.run(KsApplication.class, args);
	}

}
