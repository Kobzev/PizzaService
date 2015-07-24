package com.epam.pizzaservice.infostructure;

import java.lang.reflect.Constructor;

public class JavaConfigApplicationContext implements ApplicationContext {
	private Config config;

	public JavaConfigApplicationContext(Config config) {
		this.config = config;
	}

	@Override
	public Object getBean(String beanName) throws Exception{
		Class<?> clazz = config.getImplementation(beanName);
		
		Constructor<?> constructor = clazz.getConstructors()[0];
		//Parameter[] parameters = constructor.getParameters();
		Class<?>[] parameters = constructor.getParameterTypes();
		
		if (parameters.length == 0) {
			return clazz.newInstance();
		}
		
		Object[] constructorParameters = new Object[parameters.length];
		
		for (int i=0; i<parameters.length; i++) {
			String className = parameters[i].getSimpleName();
			className = className.substring(0, 1).toLowerCase() + className.substring(1);
			
			constructorParameters[i] = getBean(className);
		}

		return constructor.newInstance(constructorParameters);
	}

}
