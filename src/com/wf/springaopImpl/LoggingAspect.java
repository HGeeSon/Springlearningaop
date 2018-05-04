package com.wf.springaopImpl;

import java.util.Arrays;
import java.util.List;

import javax.annotation.Resource;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;


@Order(3)
@Component
@Aspect
public class LoggingAspect {

	// 前置通知： 在目标 方法开始之前进行执行的通知
	@Before( "ValidateAspect.declareJoinPointExpression()")
//	@Before( "execution(public int com.wf.springaopImpl.ArithmeticCalculatorImpl.*(int , int))")
	public void brforelogging(JoinPoint joinPoint){ //注意 JoinPoint 的包		
		String methodName = joinPoint.getSignature().getName();
		List<Object> args = Arrays.asList(joinPoint.getArgs());
		
		System.out.println("The brforelogging methor"+ methodName+" begin with"+args);
		
	}
	// 后置通知： 在目标方法执行之后，无论是否发生异常，都进行执行的通知
	//在后置通知中，不能访问目标方法的执行结果
//	@After("execution(public int com.wf.springaopImpl.ArithmeticCalculatorImpl.*(int , int)))")
	public void afterlogging(JoinPoint joinPoint){
		String methodName = joinPoint.getSignature().getName();
		System.out.println("The afterlogging method "+methodName+" end");
	}
	
	/**
	 * 返回通知： 在目标方法正常结束时，所执行的通知
	 * 
	 * 返回通知可以访问到方法的返回值
	 * 	 */
//	@AfterReturning(value="execution(public int com.wf.springaopImpl.ArithmeticCalculatorImpl.*(int , int)))",returning="result")
	public void afterreturninglogging(JoinPoint joinPoint,Object result){
		String methodName = joinPoint.getSignature().getName();
		System.out.println("The afterreturninglogging method "+methodName+" end with "+result);
		
	}
	
	/*
	 * 异常通知 ：在目标方法出现异常时才会进行执行的代码
	 * 
	 * 可以访问到异常对象，Exception参数可以指定为特定的异常 例如NullPointerException等
	 * 
	 * */
	
	@AfterThrowing(value="execution(public int com.wf.springaopImpl.ArithmeticCalculatorImpl.*(int , int)))",throwing="ex")
	public void afterthrowinglogging(JoinPoint joinPoint, Exception ex){
		String methodName = joinPoint.getSignature().getName();
		System.out.println("The afterthrowinglogging method "+methodName+" occurs excetion: "+ex);
		
	}
	
	
	
		/*
		 * 
		 * 环绕通知
		 * 
		 * 环绕通知需要指定参数ProceedingJoinPoint，必须存在
		 * 环绕通知类似于动态代理的全过程，ProceedingJoinPoint 类型的参数可以决定是否执行目标方法
		 * 环绕通知必须存在返回值，返回值即为目标方法的返回值。
		 * 环绕通知的存在会导致前置通知和异常通知不进行执行，且可能会导致返回通知返回的结果失误
		 * 
		 * */
	@Around(value="execution(public int com.wf.springaopImpl.ArithmeticCalculatorImpl.*(int , int)))")
	public Object aroundlogging(ProceedingJoinPoint pjd){
		Object result =null;
		String methodName = pjd.getSignature().getName();
		  List<Object> args = Arrays.asList(pjd.getArgs());

		try {
			// 前置通知

			System.out.println("The aroundlogging methor"+ methodName+" begin with"+args);
			result = pjd.proceed();
			// 返回通知
			System.out.println("The aroundlogging method "+methodName+" end with "+result);

		} catch (Throwable e) {
			System.out.println("The aroundlogging method "+methodName+" occurs excetion: "+e);
			// 异常通知
			e.printStackTrace();
		}
		//后置通知
		System.out.println("The aroundlogging method "+methodName+" end");
		return 100;
	}


	
	
}
