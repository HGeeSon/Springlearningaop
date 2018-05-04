package com.wf.springaop;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

public class ArithmeticCalculatorLoggingProxy {
	
	private ArithmeticCalculator target;
	
	public ArithmeticCalculator getLoggingProxy (){
		
		ArithmeticCalculator proxy = null;
		
		
		
		
		
		
		// �����������һ����������������
		ClassLoader loader = target.getClass().getClassLoader();
		
		//����������ͣ�����������Щ����
		Class [] interfaces = new Class[]{ArithmeticCalculator.class};
		
		
		InvocationHandler h = new InvocationHandler() {
			/*proxy �����ڷ��صĴ������һ������£���invoke�����ж���ʹ�øö���,�������ѭ��
			 * method �����ڱ����õķ���
			 * args :���÷���ʱ������Ĳ���
			 * 
			 * */
			
			@Override
			public Object invoke(Object proxy, Method method, Object[] args)
					throws Throwable {
				
				String methodName = method.getName();
				//��־
				System.out.println("the method"+methodName+"begin with "+Arrays.asList(args) );
				
				
				
				//ִ�з���
				Object result=null;
				try {
					// ǰ��֪ͨ
					result = method.invoke(target, args);
					// ����֪ͨ
				} catch (Exception e) {
					// �쳣֪ͨ
					e.printStackTrace();
				}
				//����֪ͨ
				
				
				//��־
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
