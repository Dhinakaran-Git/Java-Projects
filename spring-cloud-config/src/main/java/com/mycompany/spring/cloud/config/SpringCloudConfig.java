package com.mycompany.spring.cloud.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class SpringCloudConfig {

    public static void main(String[] args) {
        SpringApplication.run(SpringCloudConfig.class, args);
    }
}
