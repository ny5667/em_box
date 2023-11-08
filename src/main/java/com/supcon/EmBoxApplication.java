package com.supcon;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.socket.server.standard.ServerEndpointExporter;

/**
 * @author zhangjunwei1
 */
@ComponentScan
@SpringBootApplication()
public class EmBoxApplication {
    public static void main(String[] args) {
        SpringApplication.run(EmBoxApplication.class, args);
    }


    @Bean
    public ServerEndpointExporter serverEndpointExporter() {
        return new ServerEndpointExporter();
    }
}
