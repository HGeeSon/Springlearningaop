package com.wf.springaop;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ArithmeticCalculator arithmeticCalculator  = new ArithmeticCalculatorImpl();
		System.out.println("-------û����־-------");
		System.out.println(arithmeticCalculator.add(2, 5));
		System.out.println(arithmeticCalculator.sub(7, 5));
		System.out.println(arithmeticCalculator.mul(2, 5));
		System.out.println(arithmeticCalculator.div(15, 5));
		
		
		System.out.println("-------������־-------");
		ArithmeticCalculator arithmeticCalculator01  = new ArithmeticCalculatorLoggingImpl();
		
		arithmeticCalculator01.add(2, 5);
		arithmeticCalculator01.sub(7, 5);
		arithmeticCalculator01.mul(2, 5);
		arithmeticCalculator01.div(15, 5);
		

		System.out.println("-------ʹ�ô���-------");
		ArithmeticCalculator target  = new ArithmeticCalculatorImpl();

		ArithmeticCalculator arithmeticCalculatorProxy = new ArithmeticCalculatorLoggingProxy(target).getLoggingProxy();
		System.out.println(arithmeticCalculatorProxy.add(1,2));
		System.out.println(arithmeticCalculatorProxy.sub(4,2));
		System.out.println(arithmeticCalculatorProxy.mul(2, 5));
		System.out.println(arithmeticCalculatorProxy.div(15, 5));
		

	}

}
