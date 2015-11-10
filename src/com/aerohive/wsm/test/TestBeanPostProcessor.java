package com.aerohive.wsm.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestBeanPostProcessor {

	@Test
	public void test() {
		/** 加载Bean lifeCycle, 会进入MyBeanPostProcessor */
		@SuppressWarnings("resource")
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext1.xml");

		/** 这里不会再进入MyBeanPostProcessor，因为该Bean是单态的，上面已经实例化好了 */
		context.getBean("lifeCycle");

		/**
		 * Bean lifeCycleProto的scope是prototype,对于prototype的bean，只有在获取的时候才会创建实例，进行初始化，
		 * 在加载applicationContext.xml的时候是不会进行实例化的，而单态会，这就是区别
		 */
		context.getBean("lifeCycleProto");
	}

}
