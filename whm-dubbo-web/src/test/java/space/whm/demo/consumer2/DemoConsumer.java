/*
 * Copyright 1999-2011 Alibaba Group.
 *  
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *  
 *      http://www.apache.org/licenses/LICENSE-2.0
 *  
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package space.whm.demo.consumer2;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import space.whm.demo.api.entity.Whmtest;
import space.whm.demo.api.service.DemoService;
import space.whm.demo.api.service.WhmtestService;

/**
 * 启动provider, 进行测试.
 * @author whm
 *
 */
public class DemoConsumer {
	
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("classpath:whm-dubbo-web.xml");
        DemoService demoService = (DemoService) context.getBean("demoService");
        WhmtestService whmtestService = (WhmtestService) context.getBean("whmtestService");
        
		Whmtest whmtest = whmtestService.load(1L);
		System.out.println(whmtest.getName());
        
        for (int i = 0; i < 2; i ++) {
            try {
            	String hello = demoService.sayHello("world" + i);
                System.out.println("[" + new SimpleDateFormat("HH:mm:ss").format(new Date()) + "] " + hello);
            } catch (Exception e) {
                e.printStackTrace();
            }
            try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        }
        
        whmtestService.sysout52zyj();
	}

}