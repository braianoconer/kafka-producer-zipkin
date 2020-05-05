package com.playground.mcsv1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class Mcsv1Application {

	public static void main(String[] args) {
		SpringApplication.run(Mcsv1Application.class, args);
	}

}
