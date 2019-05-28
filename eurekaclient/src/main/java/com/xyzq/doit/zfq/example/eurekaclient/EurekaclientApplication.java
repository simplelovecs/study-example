package com.xyzq.doit.zfq.example.eurekaclient;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@SpringBootApplication
@RestController
public class EurekaclientApplication {

	public static void main(String[] args) {
		SpringApplication.run(EurekaclientApplication.class, args);
	}

	@Autowired
	private EurekaClient discoveryClient;

	public String serviceUrl() {
		List<InstanceInfo> instanceInfos =  discoveryClient.getInstancesByVipAddress("CLIENTAAAA", false);
		for(InstanceInfo info : instanceInfos) {
			System.out.println(info.getHomePageUrl());

		}

		InstanceInfo instance = discoveryClient.getNextServerFromEureka("CLIENTAAAA", false);
//		System.out.println(instance.getInstanceId());
//		System.out.println(instance.getHomePageUrl());
//		System.out.println(instance.getIPAddr() + ":" + instance.getPort());
//		System.out.println(instance.getStatusPageUrl());
//		System.out.println(instance.getVIPAddress());

		return instance.getHomePageUrl();
	}

	@RequestMapping("/")
	public String home() {
		serviceUrl();
		return "Hello world";
	}

}

