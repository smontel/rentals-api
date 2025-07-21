package com.openclassrooms.rentalsapi;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;


@SpringBootApplication
@EnableJpaAuditing
public class RentalsApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(RentalsApiApplication.class, args);
	}

}
