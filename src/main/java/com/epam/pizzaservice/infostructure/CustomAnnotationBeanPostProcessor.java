package com.epam.pizzaservice.infostructure;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

public class CustomAnnotationBeanPostProcessor implements BeanPostProcessor{

	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		ProxyForBenchmarkAnnotationCGLIB proxyForBenchmarkAnnotationCGLIB = new ProxyForBenchmarkAnnotationCGLIB();
		return proxyForBenchmarkAnnotationCGLIB.checkAndCreateProxyObjForBenckmark(bean);		
	}

	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
		return bean;
	}

}
