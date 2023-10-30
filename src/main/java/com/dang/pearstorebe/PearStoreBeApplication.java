package com.dang.pearstorebe;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(
		scanBasePackages = {"com.dang.pearstorebe","com.dang.commonlib"}
)
public class PearStoreBeApplication {

	public static void main(String[] args) {
		SpringApplication.run(PearStoreBeApplication.class, args);
	}

}
