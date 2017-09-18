package com.didispace;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableEurekaClient
@EnableTransactionManagement
public class Application {
	public final  static String Queue="A";
	public final  static int MAX_SEND=5;

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
