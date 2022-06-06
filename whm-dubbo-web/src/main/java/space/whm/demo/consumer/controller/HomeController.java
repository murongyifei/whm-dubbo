package space.whm.demo.consumer.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.slf4j.Slf4j;
import space.whm.demo.api.entity.Whmtest;
import space.whm.demo.api.service.DemoService;
import space.whm.demo.api.service.WhmtestService;
import space.whm.demo.consumer.aspect.CheckNet;


@Controller
@Slf4j
public class HomeController {
	@Autowired
	private DemoService demoService;
	@Autowired
	private WhmtestService whmtestService;
	
	@RequestMapping("/test")
    public void getMsg(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String hello = demoService.sayHello("world");
        System.out.println("[" + new SimpleDateFormat("HH:mm:ss").format(new Date()) + "] " + hello);
        
        response.setContentType("application/json;charset=UTF-8");
		response.getWriter().write(hello);
    }
	
	@RequestMapping("/testth")
	public String testthymeleaf(Model model) throws Exception {
		String hello = demoService.sayHello("world");
		System.out.println("[" + new SimpleDateFormat("HH:mm:ss").format(new Date()) + "] " + hello);
		
		Whmtest whmtest = whmtestService.load(1L);
		System.out.println(whmtest.getName());
		whmtestService.sysout52zyj();
		
		model.addAttribute("userName", hello+" "+whmtest.getName());
		return "hello";
	}
	
	@RequestMapping("/testjpa")
	public String testjpa(Model model) throws Exception {
		Whmtest whmtest = whmtestService.load(1L);
		whmtestService.sysout52zyj();
		model.addAttribute("userName",whmtest.getName());
		return "hello";
	}
	
	/**
	 * 
	 * @param model
	 * @param request
	 * @param action
	 * @param msg
	 * @return
	 * http://localhost:9000/session?action=set&msg=abcd
	 * http://localhost:9000/session?action=get
	 */
	@RequestMapping("/session")
	public String index(Model model,HttpServletRequest request,String action,String msg){
		HttpSession session=request.getSession();
		if ("set".equals(action)){
			session.setAttribute("msg", msg);
		}else if ("get".equals(action)){
			String message=(String)session.getAttribute("msg");
			System.out.println("message = " + message);
			model.addAttribute("msgFromRedis",message);
		}
		return "index";
		//ceshi123

	}
	
}
