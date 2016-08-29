package com.elisonwell.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.List;

/**
 * Hello world!
 *
 */
public class App {

	@SuppressWarnings("rawtypes")
	public static List getList(final List list) {
		return (List) Proxy.newProxyInstance(App.class.getClassLoader(), new Class[] { List.class },
				new InvocationHandler() {
					private Object target = list;

					public Object invoke(Object paramObject, Method paramMethod, Object[] paramArrayOfObject)
							throws Throwable {
						System.out.println("调用代理！");
						return paramMethod.invoke(target, paramArrayOfObject);
					}
				});
	}

	public static Subject getSubject(final Subject subject) {
		return (Subject) Proxy.newProxyInstance(App.class.getClassLoader(), subject.getClass().getInterfaces(),
				new InvocationHandler() {
			/*
			 * 需要定义方法调用的真实对象，而方法invoke的参数paramObject不是指这个对象，暂时不知道该参数有何用
			 */
					private Object target = subject;

					public Object invoke(Object paramObject, Method paramMethod, Object[] paramArrayOfObject)
							throws Throwable {
						System.out.println("调用代理！method:" + paramMethod.getName());
						return paramMethod.invoke(target, paramArrayOfObject);
					}
				});
	}

	public static void main(String[] args) {

		Subject proxySubject = (Subject) getSubject(new Subject() {
			public void hello(String str) {
				System.out.println(str);
			}
		});

		System.out.println("proxySubject class:" + proxySubject.getClass().getName());
		proxySubject.hello("你好！");
	}
}
