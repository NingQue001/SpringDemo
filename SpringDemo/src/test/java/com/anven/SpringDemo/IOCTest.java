package com.anven.SpringDemo;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.anven.SpringDemo.service.UserService;

/*
 * Note: Ŀ¼�ṹ������½�maven��Ŀʱ���Ŀ¼һ�£��Ͳ���Ҫ�޸���Ŀ��Build Path
 * ����groupIdΪcom.anven,artifactIdΪSpringDemo,��class����Ŀ¼Ϊcom.anven.SpringDemo
 * 
 */
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
