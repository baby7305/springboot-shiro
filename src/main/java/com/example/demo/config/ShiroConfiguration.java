package com.example.demo.config;

import java.util.LinkedHashMap;
import java.util.Map;

import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 这是Shiro 配置类 （1）需要配置ShiroFilterFactoryBean （2）配置SecurityManager
 * 
 * @author Angel -- 守护天使
 * @version v.0.1
 * @date 2017年10月13日
 */
@Configuration // 这是配置类.
public class ShiroConfiguration {

	/**
	 * 定义shiro Filter 工厂类.
	 * 
	 * @param securityManager
	 * @return
	 */
	@Bean // 注入shiroFilter.
	public ShiroFilterFactoryBean shiroFilter(SecurityManager securityManager) {

		/*
		 * 1、定义ShiroFactoryBean. 2、设置SecurityManager; 3、配置拦截器+配置登录和登录成功的地址.
		 * 4、返回ShiroFactoryBean.
		 */
		// 1、定义ShiroFactoryBean.
		ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();

		// 2、设置SecurityManager;
		shiroFilterFactoryBean.setSecurityManager(securityManager);

		// 3、配置拦截器.: 使用Map进行配置:LinkedHashMap ，LinkedHashMap是有序的, shiro会根据添加的顺序进行拦截.
		Map<String, String> filterChainMap = new LinkedHashMap<String, String>();

		// 配置退出. 过滤器：logout,这个由shiro进行实现的.
		filterChainMap.put("/logout", "logout");

		// authc:所有的URL都必须认证通过才可以访问.
		filterChainMap.put("/**", "authc");

		// 设置默认登录的URL.
		shiroFilterFactoryBean.setLoginUrl("/login");
		// 设置成功之后要跳转的链接.
		shiroFilterFactoryBean.setSuccessUrl("/index");
		// 未授权界面.
		shiroFilterFactoryBean.setUnauthorizedUrl("/403");

		shiroFilterFactoryBean.setFilterChainDefinitionMap(filterChainMap);

		// 4、返回ShiroFactoryBean.
		return shiroFilterFactoryBean;
	}

	/**
	 * 定义Shiro的安全管理器.
	 * 
	 * @return
	 */
	@Bean
	public SecurityManager securityManager() {
		DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
		return securityManager;
	}

}
