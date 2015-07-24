package com.epam.pizzaservice.infostructure;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class JavaConfigApplicationContext implements ApplicationContext {
	private Config config;
	private final Map<String, Object> beans = new HashMap<>();

	public JavaConfigApplicationContext(Config config) {
		this.config = config;
	}

	@Override
	public Object getBean(String beanName) throws Exception{
		Object bean = beans.get(beanName);
		
		if (bean != null) {
			return bean;
		}
		
		BeanBuilder beanBuilder = new BeanBuilder(beanName);
		beanBuilder.createObject();
		beanBuilder.createProxy();
		beanBuilder.callInitMethod();
		
		return beanBuilder.getObject();
		
		
		/*Class<?> clazz = config.getImplementation(beanName);
		
		Constructor<?> constructor = clazz.getConstructors()[0];
		//Parameter[] parameters = constructor.getParameters();
		Class<?>[] parameters = constructor.getParameterTypes();
		
		if (parameters.length == 0) {
			bean = clazz.newInstance();
			beans.put(beanName, bean);
			return bean;
		}
		
		Object[] constructorParameters = new Object[parameters.length];
		
		for (int i=0; i<parameters.length; i++) {
			String className = parameters[i].getSimpleName();
			className = className.substring(0, 1).toLowerCase() + className.substring(1);
			
			constructorParameters[i] = getBean(className);
		}

		bean = constructor.newInstance(constructorParameters);
		beans.put(beanName, bean);
		return bean;*/
	}
	
	class BeanBuilder{
		private Object obj;
		private String beanName;
				
		public BeanBuilder(String beanName) {
			this.beanName = beanName;
		}

		public void createObject() throws Exception{
			Class<?> clazz = config.getImplementation(beanName);
			
			Constructor<?> constructor = clazz.getConstructors()[0];
			//Parameter[] parameters = constructor.getParameters();
			Class<?>[] parameters = constructor.getParameterTypes();
			
			if (parameters.length == 0) {
				obj = clazz.newInstance();
				beans.put(beanName, obj);
				return;
			}
			
			Object[] constructorParameters = new Object[parameters.length];
			
			for (int i=0; i<parameters.length; i++) {
				String className = parameters[i].getSimpleName();
				className = className.substring(0, 1).toLowerCase() + className.substring(1);
				
				constructorParameters[i] = getBean(className);
			}

			obj = constructor.newInstance(constructorParameters);
			beans.put(beanName, obj);
		}	
		
		public void callInitMethod() throws Exception{
			Class<?> clazz = obj.getClass();
			Method method;
			try {
				method = clazz.getMethod("init");
			} catch (NoSuchMethodException e) {
				return;
			}
			
			method.invoke(obj);
		}
		
		public void createProxy(){}
		
		public Object getObject(){
			return obj;
		}
	}

}
