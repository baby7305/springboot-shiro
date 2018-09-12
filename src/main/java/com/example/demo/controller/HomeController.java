package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {

	@RequestMapping(value = { "/", "/index" })
	public String index() {
		return "/index";
	}

	// 只能使用get方式进行请求. post:在点击登录的时候进行使用.
	@RequestMapping(value = { "/login" }, method = RequestMethod.GET)
	public String login() {
		return "/login";
	}

}
