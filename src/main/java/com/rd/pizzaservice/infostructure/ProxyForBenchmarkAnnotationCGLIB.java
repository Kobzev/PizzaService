package com.rd.pizzaservice.infostructure;

import java.lang.reflect.Method;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

/**
 * Created by Konstiantyn on 7/27/2015.
 */
public class ProxyForBenchmarkAnnotationCGLIB {
    Object checkAndCreateProxyObjForBenckmark(Object object) {
        Class<?> clazz = object.getClass();

        for (Method m : clazz.getMethods()){
            if (m.isAnnotationPresent(Benchmark.class)) return cteateProxyObj(object);
        }
        return object;
    }
    
    private Object cteateProxyObj(final Object o){
    	Class<?> clazz = o.getClass();
    	Enhancer enhancer = new Enhancer();
    	if (Enhancer.isEnhanced(clazz)) {
    		enhancer.setSuperclass(clazz.getSuperclass());
    	}else enhancer.setSuperclass(clazz);
        
        enhancer.setCallback(new MethodInterceptor() {
			
        	public Object intercept(Object object, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
                if (method.isAnnotationPresent(Benchmark.class)) { 
                	System.out.println("Benchmark start: " + method.getName());
                    long startTime = System.nanoTime();

                    Object retVal = method.invoke(o, args);

                    long result = System.nanoTime() - startTime;
                    System.out.println(result);
                    System.out.println("Benchmark finish: " + method.getName());
                	
                    return retVal;      
                }
         
                return method.invoke(o, args);
            }
		});
             
        Object proxy = enhancer.create();         
        return proxy;    	
    }
}
