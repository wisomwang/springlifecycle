package com.aerohive.wsm;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/** TestLifeCycle是一个Bean */
public class LifeCycleBean implements BeanFactoryAware, ApplicationContextAware, InitializingBean, DisposableBean,
		BeanNameAware {

	@SuppressWarnings("unused")
	private BeanFactory beanFactory;
	
	@SuppressWarnings("unused")
	private ApplicationContext applicationContext;
	
	private String name;

	/** bean中配置了<property name="name" value="ssss"></property>会调用setName方法 */
	public void setName(String name) {
		System.out.println("method setName is called");
		System.out.println("name=" + name);
		this.name = name;
	}

	public String getName() {
		return name;
	}

	/**
	 * override
	 * BeanNameAware的setBeanName()方法，在调用任何Bean生命周期回调（初始化或者销毁）方法之前就调用这个方法
	 * 对应配置文件中<bean id="lifeCycle".../>
	 */
	@Override
	public void setBeanName(String name) {
		System.out.println("method setBeanName is called");
	};

	/** 实现了BeanFactoryAware */
	@Override
	public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
		this.beanFactory = beanFactory;
		System.out.println("method setBeanFactory is called");
	};

	/** 实现了ApplicationContextAware */
	@Override
	public void setApplicationContext(ApplicationContext arg0) throws BeansException {
		applicationContext = arg0;
		System.out.println("method setApplicationContext is called");
	};

	/** spring两种初始方法中的一种，另外一种见下面，这种是依赖spring的，另外一种是在xml中配置的 */
	/** 这个方法将在所有的属性被初始化后调用,但是会在init前调用 */
	/** 实现了InitializingBean */
	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("method afterPropertiesSet is called");
	}

	/** 对应配置文件中的init-method="customInit" */
	public void customInit() {
		System.out.println("method customInit is called");
	}

	/** 实现了DisposableBean */
	@Override
	public void destroy() throws Exception {
		System.out.println("method destroy is called");
	}

	/** 对应配置文件中的destroy-method="customDestory" */
	public void customDestory() {
		System.out.println("method customDestory is called");
	}
}

/**
 * BeanFactoryAware和ApplicationContextAware类似，只介绍一个 通过override
 * setBeanFactory方法可以获取beanFactory,然后通过beanFactory以及bean
 * 名字可以得到对应的bean实例，通过注入方式也可以获取bean,适用什么场合.
 * 
 * 下面这个case是，用户进入某一购物网站，下单后，可以选择多种支付方式，但有很多种，一种方案是我们把所有的
 * 支付方式的bean都注入到Pay中，另外一种是我们根据用户选择的支付方式的名字去获得对应的bean,在这种情况下 后者的方式更加合理
 * 
 * */
class Pay implements BeanFactoryAware {
	@SuppressWarnings("unused")
	private PayWay payWay;
	
	private BeanFactory beanFactory;

	@Override
	public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
		this.beanFactory = beanFactory;
	}

	@SuppressWarnings("unused")
	private void setPayWay(String payWayName) {
		payWay = (PayWay) beanFactory.getBean(payWayName);
	}

}

/** 表示支付方式，不固定，由用户选择而定 */
class PayWay {

}
