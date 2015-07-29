package com.epam.pizzaservice.infostructure;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

public class CustomAnnotationBeanPostProcessor implements BeanPostProcessor{

	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		if (bean instanceof org.springframework.cglib.proxy.Factory) {
			ProxyForBenchmarkAnnotationCGLIB proxyForBenchmarkAnnotationCGLIB = new ProxyForBenchmarkAnnotationCGLIB();
			return proxyForBenchmarkAnnotationCGLIB.checkAndCreateProxyObjForBenckmark(bean);
		}
		
		ProxyForBenchmarkAnnotation proxyForBenchmarkAnnotation = new ProxyForBenchmarkAnnotation();
		return proxyForBenchmarkAnnotation.checkAndCreateProxyObjForBenckmark(bean);
		
	}

	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
		return bean;
	}

}
