package com.anven.SpringDemo;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.anven.SpringDemo.service.UserService;

public class IOCTest {
	@Test
	public void testAddUser() { 
		//从spring容器中获得 
		String xmlPath="applicationContext.xml"; 
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext(xmlPath); 
		//这里就不需要new它的实现类对象了
		UserService userService = (UserService) applicationContext.getBean("userService"); 
		userService.addUser(); 
	}
}
