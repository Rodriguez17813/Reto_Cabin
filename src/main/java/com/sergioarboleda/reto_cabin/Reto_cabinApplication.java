package com.sergioarboleda.reto_cabin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@EnableConfigurationProperties
@EntityScan(basePackages ={"com.sergioarboleda.reto_cabin.model"})
@SpringBootApplication
public class Reto_cabinApplication {

	public static void main(String[] args) {
		SpringApplication.run(Reto_cabinApplication.class, args);
	}

}
