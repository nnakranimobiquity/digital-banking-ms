package com.mobiquity.neel.digitalbankingconfig;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class DigitalBankingConfigApplication {

	public static void main(String[] args) {
		SpringApplication.run(DigitalBankingConfigApplication.class, args);
	}

}
