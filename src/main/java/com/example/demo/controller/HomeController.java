package com.example.demo.controller;

import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

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

	@RequestMapping(value = {"/login"}, method = RequestMethod.POST)
	public String login(HttpServletRequest request, Map<String, Object> map) {

		//登录失败从request对象中可以获取shiro处理异常的细信息.
		//shiroLoginFailure.
		String exception = (String) request.getAttribute("shiroLoginFailure");
		System.out.println("exception=" + exception);
		String msg = "";
		if (exception != null) {
			if (UnknownAccountException.class.getName().equals(exception)) {
				msg = "账号不存在";
			} else if (IncorrectCredentialsException.class.getName().equals(exception)) {
				msg = "密码不正确";
			} else {
				msg = "else -->" + exception;
			}
		}
		map.put("msg", msg);
		return "/login";
	}

}
