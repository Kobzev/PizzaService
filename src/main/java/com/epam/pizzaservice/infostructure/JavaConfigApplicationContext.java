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
		beanBuilder.callInitMethod();
		beanBuilder.createProxy();		
		
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
		
		public void createProxy(){
			ProxyForBenchmarkAnnotation proxyForBenchmarkAnnotation = new ProxyForBenchmarkAnnotation();
			obj = proxyForBenchmarkAnnotation.checkAndCreateProxyObjForBenckmark(obj);
		}

		/*private Object checkAndCreateProxyObjForBenckmark(Object object) {
			Class<?> clazz = object.getClass();

			for (Method m : clazz.getMethods()){
				if (m.isAnnotationPresent(Benchmark.class)) object = cteateProxyObj(object);
			}
			return object;
		}

		private Object cteateProxyObj( final Object o){
			final Class<?> type = o.getClass();
			return Proxy.newProxyInstance(type.getClassLoader(), type.getInterfaces(), new InvocationHandler() {
				@Override
				public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
					Object retVal;
					if (!type.getMethod(method.getName(), method.getParameterTypes()).isAnnotationPresent(Benchmark.class)) {
						retVal = method.invoke(o, args);
					}
					else {
						System.out.println("Benchmark start: " + method.getName());
						long startTime = System.nanoTime();

						retVal = method.invoke(o, args);

						long result = System.nanoTime() - startTime;
						System.out.println(result);
						System.out.println("Benchmark finish: " + method.getName());
					}

					return retVal;
				}
			});

		}*/
		
		public Object getObject(){
			return obj;
		}
	}

}
