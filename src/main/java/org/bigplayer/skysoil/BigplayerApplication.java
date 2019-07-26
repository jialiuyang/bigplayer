package org.bigplayer.skysoil;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;

@MapperScan(basePackages = {"org.bigplayer.skysoil.mapper"})
@EnableHystrix
@EnableDiscoveryClient
@SpringBootApplication
@EnableFeignClients
public class BigplayerApplication {

    public static void main(String[] args) {
        SpringApplication.run(BigplayerApplication.class, args);
    }

}