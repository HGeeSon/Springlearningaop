package com.wf.springaop;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

public class ArithmeticCalculatorLoggingProxy {
	
	private ArithmeticCalculator target;
	
	public ArithmeticCalculator getLoggingProxy (){
		
		ArithmeticCalculator proxy = null;
		
		
		
		
		
		
		// 代理对象有哪一个类加载器负责加载
		ClassLoader loader = target.getClass().getClassLoader();
		
		//代理对象类型，即其中有哪些方法
		Class [] interfaces = new Class[]{ArithmeticCalculator.class};
		
		
		InvocationHandler h = new InvocationHandler() {
			/*proxy ：正在返回的代理对象，一般情况下，在invoke方法中都不使用该对象,会造成死循环
			 * method ：正在被调用的方法
			 * args :调用方法时，传入的参数
			 * 
			 * */
			
			@Override
			public Object invoke(Object proxy, Method method, Object[] args)
					throws Throwable {
				
				String methodName = method.getName();
				//日志
				System.out.println("the method"+methodName+"begin with "+Arrays.asList(args) );
				
				
				
				//执行方法
				Object result=null;
				try {
					// 前置通知
					result = method.invoke(target, args);
					// 返回通知
				} catch (Exception e) {
					// 异常通知
					e.printStackTrace();
				}
				//后置通知
				
				
				//日志
				System.out.println("the method"+methodName+"end with "+result );
				
				return result;
			}
		};
		
		proxy = (ArithmeticCalculator) Proxy.newProxyInstance(loader, interfaces, h);
		return proxy;
		
		
	}
	
	

	public ArithmeticCalculatorLoggingProxy(ArithmeticCalculator target) {
		this.target = target;
	}


}
