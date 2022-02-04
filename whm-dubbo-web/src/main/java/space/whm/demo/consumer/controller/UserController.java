package space.whm.demo.consumer.controller;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import space.whm.demo.api.entity.Whmtest;
import space.whm.demo.api.service.DemoService;
import space.whm.demo.api.service.WhmtestService;

@RestController
@RequestMapping("/springmvc")
public class UserController {
	@Autowired
	private WhmtestService whmtestService;

	@RequestMapping(value = "/{name}", method = RequestMethod.GET)
	public String sayHello(@PathVariable String name) {
		return name;
		
		
	}

	@RequestMapping(value = "/api/addUser", method = RequestMethod.POST)
	public Serializable addUserInfo(@RequestBody Whmtest user) {
		Serializable result = whmtestService.insert(user);
		return result;
	}

	@RequestMapping(value = "/api/getUser/{id}", method = RequestMethod.GET)
	public Whmtest getUserInfo(@PathVariable long id) {
		return whmtestService.load(id);
	}

}
