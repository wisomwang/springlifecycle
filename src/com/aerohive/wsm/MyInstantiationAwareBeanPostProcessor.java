package com.aerohive.wsm;

import java.beans.PropertyDescriptor;

import org.springframework.beans.BeansException;
import org.springframework.beans.PropertyValues;
import org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessorAdapter;

/** 全局的配置，任何Bean的创建时，都会进入,是在BeanFactoryPostProcessor之后被调用 */
/** 能用BeanPostProcessor完成的就不用这个类，确实需要这个类的扩展功能再考虑 */
public class MyInstantiationAwareBeanPostProcessor extends InstantiationAwareBeanPostProcessorAdapter {

	public MyInstantiationAwareBeanPostProcessor() {
		super();
		System.out.println("这是InstantiationAwareBeanPostProcessorAdapter实现类构造器！！");
	}

	/** 在Bean实例之前被调用，也可以理解为Bean还没有被创建 */
	/** 可以返回Bean的代理，不然要返回null */
	/** 跟BeanPostProcessor.postProcessBeforeInitialization作用类似 */
	@Override
	public Object postProcessBeforeInstantiation(@SuppressWarnings("rawtypes") Class beanClass, String beanName) throws BeansException {
		System.out.println("InstantiationAwareBeanPostProcessor调用postProcessBeforeInstantiation方法");

		/** 这里要返回null,不然会短路，得不到Bean */
		return null;
	}

	/** 设置属性之前被调用，这里就是在LifeCycleBean.setName()之前会调用 */
	@Override
	public PropertyValues postProcessPropertyValues(PropertyValues pvs, PropertyDescriptor[] pds, Object bean,
			String beanName) throws BeansException {
		System.out.println("InstantiationAwareBeanPostProcessor调用postProcessPropertyValues方法");
		return pvs;
	}

	/**
	 * Bean实例化调用，在BeanPostProcessor.postProcessAfterInitialization后调用,方法签名是一样的，
	 * 作用类似
	 */
	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		System.out.println("InstantiationAwareBeanPostProcessor调用postProcessAfterInitialization方法");
		return bean;
	}

}
