package com.epam.pizzaservice.infostructure;

public class ObjectFactory {
	private static ObjectFactory objectInstance;
	private Config config = new JavaConfig();
	
	private ObjectFactory(){}

	public static ObjectFactory getInstance() {
		if (objectInstance == null) {
			objectInstance = new ObjectFactory();
		}
		return objectInstance;
	}

	public Object createObject(String string) throws InstantiationException, IllegalAccessException {
		Class<?> clazz = config.getImplementation(string);
		return clazz.newInstance();
	}

}
