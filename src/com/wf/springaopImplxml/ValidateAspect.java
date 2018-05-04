package com.wf.springaopImplxml;

import java.util.Arrays;
import java.util.List;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

public class ValidateAspect {

	public void declareJoinPointExpression(){
	} 	
	
	
	public void brforeValidate(JoinPoint joinPoint){ //×¢Òâ JoinPoint µÄ°ü		
		String methodName = joinPoint.getSignature().getName();
		List<Object> args = Arrays.asList(joinPoint.getArgs());
		
		System.out.println("----------The Validate methor"+ methodName+" begin with"+args);
		
	}
	
	public void afterValidate(JoinPoint joinPoint){
		String methodName = joinPoint.getSignature().getName();
		System.out.println("The afterValidate method "+methodName+" end");
	}
	
}
