/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package space.whm.demo.dal.provider;

import java.util.concurrent.CountDownLatch;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

import tk.mybatis.spring.annotation.MapperScan;

/**
 * Dubbo Registry ZooKeeper Provider Bootstrap
 *
 */
@SpringBootApplication
@EnableDubbo(scanBasePackages = {"space.whm.demo.dal.provider.service.impl"})
@EnableScheduling
@MapperScan(basePackages = "space.whm.demo.dal.provider.dao")
public class DubboMybatisTkProvider {
	public static void main(String[] args) throws Exception {
		SpringApplication.run(DubboMybatisTkProvider.class, args);
        System.out.println("dubbo service started");
        new CountDownLatch(1).await();
    }
}
