package space.whm.demo.consumer;

import java.util.concurrent.ThreadPoolExecutor;

import org.apache.curator.shaded.com.google.common.util.concurrent.ThreadFactoryBuilder;
import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ImportResource;

//import com.sxy618.log.threadpool.TtlThreadPoolTaskExecutor;

/**
 * Dubbo Registry ZooKeeper Consumer Bootstrap
 */
@EnableDubbo
@SpringBootApplication
@ImportResource(value = { "whm-dubbo-web.xml" })
@ComponentScan(basePackages = "space.whm.demo")
public class DubboConsumer extends SpringBootServletInitializer {

	public static void main(String[] args) throws Exception {
//	    TtlThreadPoolTaskExecutor paymentThreadPool = new TtlThreadPoolTaskExecutor();
//        paymentThreadPool.setCorePoolSize(5);
//        paymentThreadPool.setMaxPoolSize(10);
//        paymentThreadPool.setKeepAliveSeconds(60);
//        paymentThreadPool.setQueueCapacity(1000);
//        paymentThreadPool.setThreadFactory(new ThreadFactoryBuilder().setNameFormat("trans-dispose-%d").build());
//        paymentThreadPool.setRejectedExecutionHandler(new ThreadPoolExecutor.AbortPolicy());
//        paymentThreadPool.initialize();
//        paymentThreadPool.execute(() -> {
//            System.out.println("异步线程执行");
//        });
	    
		SpringApplication.run(DubboConsumer.class, args);
	}

}
