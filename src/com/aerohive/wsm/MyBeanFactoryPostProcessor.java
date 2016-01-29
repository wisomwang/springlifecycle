package com.aerohive.wsm;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;

/** 这是全局的，扩展了Spring默认的BeanFactoryPosstProcessor, 在Bean预实例之前就被调用了 */
/** 作用，可以修改Bean的属性，在配置文件中Bean leftCycle的name的值是single,我们在这里可以覆盖原来的属性值 */
public class MyBeanFactoryPostProcessor implements BeanFactoryPostProcessor {

	public MyBeanFactoryPostProcessor() {
		super();
		System.out.println("这是BeanFactoryPostProcessor实现类构造器！！");
	}

	@Override
	public void postProcessBeanFactory(ConfigurableListableBeanFactory arg) throws BeansException {
		System.out.println("BeanFactoryPostProcessor调用postProcessBeanFactory方法");
		BeanDefinition bd = arg.getBeanDefinition("lifeCycle");

		/** 个性Bean属性值 */
		bd.getPropertyValues().addPropertyValue("name", "wsm");
	}
}
