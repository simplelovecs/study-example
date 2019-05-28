package com.xyzq.doit.zfq.example.eurekaserver;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class EurekaserverApplication {

	public static void main(String[] args) {
//		SpringApplication.run(EurekaserverApplication.class, args);
		new SpringApplicationBuilder(EurekaserverApplication.class).web(WebApplicationType.SERVLET).run(args);
	}

}

