package com.anven.SpringDemo;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.anven.SpringDemo.service.UserService;

/*
 * Note: 目录结构最好与新建maven项目时填的目录一致，就不需要修改项目的Build Path
 * 比如groupId为com.anven,artifactId为SpringDemo,则class顶层目录为com.anven.SpringDemo
 * 
 */
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
