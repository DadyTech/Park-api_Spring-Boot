package com.dev_dady.park_api;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
public class ParkApiApplication {

	public static void main(String[] args) {
		//SpringApplication.run(ParkApiApplication.class, args);
		SpringApplicationBuilder builder = new SpringApplicationBuilder(ParkApiApplication.class);
		builder.bannerMode(Banner.Mode.OFF);
		builder.run(args);


	}

}
