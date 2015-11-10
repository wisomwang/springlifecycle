package com.aerohive.wsm;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

/** 在applicationContext.xml中配置，这个自定义的BeanPostProcessor是全局的，后续所有Bean的创建都会进入这里 */
public class MyBeanPostProcessor implements BeanPostProcessor {

	/** 在任何初始化回调之后被调用 */
	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		System.out.println("postProcessAfterInitialization is called");
		System.out.println("beanName is " + beanName);
		return bean;
	};

	/**
	 * 在任何初始化之前调用该方法，在调用该方法之前，bean已经完成属性的设置，在这里你可以直接返回bean实例，
	 * 也可以对实例进行包装后返回，或者也可以返回实例的代理.在创建完Bean实例后，进行初始化之前调用
	 */
	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
		System.out.println("postProcessBeforeInitialization is called");
		System.out.println("beanName is " + beanName);
		return bean;
	};

}
