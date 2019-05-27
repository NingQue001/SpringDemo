package com.anven.SpringDemo;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.anven.SpringDemo.service.UserService;

public class IOCTest {
	@Test
	public void testAddUser() { 
		//��spring�����л�� 
		String xmlPath="applicationContext.xml"; 
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext(xmlPath); 
		//����Ͳ���Ҫnew����ʵ���������
		UserService userService = (UserService) applicationContext.getBean("userService"); 
		userService.addUser(); 
	}
}
