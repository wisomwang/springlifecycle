package com.aerohive.wsm.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestBeanFactoryPostProcessor {

	@SuppressWarnings("resource")
	@Test
	public void test() {
		/** 加载Bean lifeCycle, 会进入MyBeanPostProcessor */
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext2.xml");

		/** 这里不会再进入MyBeanPostProcessor，因为该Bean是单态的，上面已经实例化好了 */
		context.getBean("lifeCycle");
	}

}
