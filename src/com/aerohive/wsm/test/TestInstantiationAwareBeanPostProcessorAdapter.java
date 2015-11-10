package com.aerohive.wsm.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.aerohive.wsm.LifeCycleBean;

public class TestInstantiationAwareBeanPostProcessorAdapter {

	@Test
	public void test() {
		/** 加载Bean lifeCycle, 会进入MyBeanPostProcessor */
		@SuppressWarnings("resource")
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext3.xml");

		/** 这里不会再进入MyBeanPostProcessor，因为该Bean是单态的，上面已经实例化好了 */
		LifeCycleBean bean = (LifeCycleBean)context.getBean("lifeCycle");
		System.out.println(bean.getName());
	}

}
