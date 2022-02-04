package space.whm.demo.dal.provider;

import java.util.concurrent.CountDownLatch;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;


@SpringBootApplication
@EnableDubbo(scanBasePackages = {"space.whm.demo.dal.provider.service.impl"})
@EnableScheduling
//@MapperScan(basePackages = "space.whm.demo.dal.provider.dao")
public class DubboMybatisPlusProvider {
	public static void main(String[] args) throws Exception {
		SpringApplication.run(DubboMybatisPlusProvider.class, args);
        System.out.println("dubbo service started");
        new CountDownLatch(1).await();
    }
}