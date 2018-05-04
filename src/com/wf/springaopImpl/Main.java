package com.wf.springaopImpl;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

	/**
	 * @param args
	 */

	public static void main(String[] args) {

		ApplicationContext cxt = new ClassPathXmlApplicationContext("ApplicationContext.xml");
		
		ArithmeticCalculator arithmeticCalculator = (ArithmeticCalculator) cxt.getBean("arithmeticCalculator");
		
		System.out.println(arithmeticCalculator.getClass().getName());
		
		int result = arithmeticCalculator.add(2, 3);
		System.out.println("Main: "+result);
//		result = arithmeticCalculator.sub(6, 3);
//		System.out.println("Main: "+result);
//		result = arithmeticCalculator.mul(2, 3);
//		System.out.println("Main: "+result);
//		result = arithmeticCalculator.div(6, 2);
//		//result = arithmeticCalculator.div(6, 0);
//		System.out.println("Main: "+result);
	}

}
