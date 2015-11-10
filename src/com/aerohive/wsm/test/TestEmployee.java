package com.aerohive.wsm.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.aerohive.wsm.LifeCycleBean;

public class TestEmployee {

	private static ApplicationContext context;

	public static void main(String[] args) {
		context = new ClassPathXmlApplicationContext("applicationContext.xml");
		LifeCycleBean service = (LifeCycleBean) context.getBean("lifeCycle");
		System.out.println("service=" + service);
		((ClassPathXmlApplicationContext) context).registerShutdownHook();
	}
	
}
