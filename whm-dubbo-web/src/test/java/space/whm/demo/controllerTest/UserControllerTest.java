package space.whm.demo.controllerTest;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.io.Serializable;
import java.util.Date;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import space.whm.demo.api.entity.Whmtest;
import space.whm.demo.api.service.WhmtestService;
import space.whm.demo.consumer.controller.UserController;


/**
 * http://jinnianshilongnian.iteye.com/blog/2004660
 * http://jinnianshilongnian.iteye.com/blog/2007180
 * git clone https://github.com/zhangkaitao/spring4-showcase.git

参考:  http://blog.csdn.net/victor_cindy1/article/details/52126161
首先是Spring的几个Annotate
RunWith(SpringJUnit4ClassRunner.class): 表示使用Spring Test组件进行单元测试;
WebAppConfiguration: 使用这个Annotate会在跑单元测试的时候真实的启一个web服务，然后开始调用Controller的Rest API，待单元测试跑完之后再将web服务停掉;
ContextConfiguration: 指定Bean的配置文件信息，可以有多种方式，这个例子使用的是文件路径形式，如果有多个配置文件，可以将括号中的信息配置为一个字符串数组来表示;
然后是Mockito的Annotate
Mock: 如果该对象需要mock，则加上此Annotate;
InjectMocks: 使mock对象的使用类可以注入mock对象，在上面这个例子中，mock对象是MailService，使用了MailService的是MailController，所以在Controller加上该Annotate;
Setup方法
MockitoAnnotations.initMocks(this): 将打上Mockito标签的对象起作用，使得Mock的类被Mock，使用了Mock对象的类自动与Mock对象关联。
mockMvc: 细心的朋友应该注意到了这个对象，这个对象是Controller单元测试的关键，它的初始化也是在setup方法里面。
Test Case
首先mock了MailService的send方法，让其返回一个成功的Result对象。
mockMvc.perform: 发起一个http请求。
post(url): 表示一个post请求，url对应的是Controller中被测方法的Rest url。
param(key, value): 表示一个request parameter，方法参数是key和value。
andDo（print()）: 表示打印出request和response的详细信息，便于调试。
andExpect（status().isOk()）: 表示期望返回的Response Status是200。
andExpect（content().string(is（expectstring））: 表示期望返回的Response Body内容是期望的字符串。
使用print打印处理的信息类似下面显示的内容:
MockHttpServletRequest:
      HTTP Method = GET
      Request URI = /springmvc/api/getUser/100000000000000
       Parameters = {}
          Headers = {}

Handler:
             Type = space.whm.demo.consumer.controller.UserController
           Method = public space.whm.demo.api.entity.Whmtest space.whm.demo.consumer.controller.UserController.getUserInfo(long)

Async:
    Async started = false
     Async result = null

Resolved Exception:
             Type = null

ModelAndView:
        View name = null
             View = null
            Model = null

FlashMap:
       Attributes = null

MockHttpServletResponse:
           Status = 200
    Error message = null
          Headers = {Content-Type=[application/json;charset=UTF-8]}
     Content type = application/json;charset=UTF-8
             Body = {"id":100000000000000,"name":"王海明","type":1,"mydate":1477367855377}
    Forwarded URL = null
   Redirected URL = null
          Cookies = []
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
public class UserControllerTest {
	private MockMvc mockMvc;

	@Mock
	private WhmtestService whmtestService;

	@InjectMocks
	private UserController userController;

	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
		this.mockMvc = MockMvcBuilders.standaloneSetup(userController).build();
	}

	@Test
	public void testGetUserInfo() throws Exception {
		long userId = 100000000000000L;
		String userName = "王海明";
		int type = 1;
		Date mydate = new Date();

		Whmtest user = new Whmtest();
		user.setId(userId);
		user.setName(userName);
		user.setType(type);
		user.setMydate(mydate);
		when(whmtestService.load(userId)).thenReturn(user);
		
		mockMvc.perform(get("/springmvc/api/getUser/{id}", userId)).andDo(print()).andExpect(status().isOk())
				.andExpect(jsonPath("id").value(userId))
				.andExpect(jsonPath("name").value(userName))
				.andExpect(jsonPath("type").value(type))
				.andExpect(jsonPath("mydate").value(mydate))
				;

		verify(whmtestService).load(userId);
	}
	
	@Test
	public void testAdd() {
		long id = 1;
		String name = "王海明";
		int type = 1;
		Date mydate = new Date();

		Whmtest user = new Whmtest();
		user.setId(id);
		user.setName(name);
		user.setType(type);
		user.setMydate(mydate);
		when(whmtestService.insert(user)).thenReturn(1);

		Serializable restUser = userController.addUserInfo(user);
		assertEquals(1, restUser);

		verify(whmtestService).insert(user);
	}

}
