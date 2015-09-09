package com.rd.pizzaservice.infostructure;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Konstiantyn on 7/27/2015.
 */
public class ProxyForBenchmarkAnnotation {
    Object checkAndCreateProxyObjForBenckmark(Object object) {
        Class<?> clazz = object.getClass();

        for (Method m : clazz.getMethods()){
            if (m.isAnnotationPresent(Benchmark.class)) return cteateProxyObj(object);
        }
        return object;
    }

    private Object cteateProxyObj( final Object o){
        final Class<?> type = o.getClass();
        
        Set<Class<?>> interfaces = new HashSet<>();
        interfaces.addAll(Arrays.asList(type.getInterfaces()));
        interfaces.addAll(Arrays.asList(type.getSuperclass().getInterfaces()));

        
        return Proxy.newProxyInstance(type.getClassLoader(), interfaces.toArray(new Class<?>[0]), new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                Object retVal;
                if (!type.getMethod(method.getName(), method.getParameterTypes()).isAnnotationPresent(Benchmark.class)) {
                    retVal = method.invoke(o, args);
                } else {
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

    }
}
