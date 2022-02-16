package com.example.demo.smm;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;
import org.springframework.retry.annotation.EnableRetry;

@MapperScan("com.example.demo.smm.mapper")
@SpringBootApplication
@EnableRetry
@EnableDubbo(scanBasePackages = {"com.example.demo.smm.service.impl"})
@ImportResource(value = { "classpath:/applicationContext-service-demo.xml" })
public class DubboMybatisProvider {

    public static void main(String[] args) {
        SpringApplication.run(DubboMybatisProvider.class, args);
    }

}
