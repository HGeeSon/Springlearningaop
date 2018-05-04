package com.wf.springaopImplxml;

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


public class LoggingAspect {

	public void brforelogging(JoinPoint joinPoint){ //ע�� JoinPoint �İ�		
		String methodName = joinPoint.getSignature().getName();
		List<Object> args = Arrays.asList(joinPoint.getArgs());
		
		System.out.println("The brforelogging methor"+ methodName+" begin with"+args);
		
	}
	public void afterlogging(JoinPoint joinPoint){
		String methodName = joinPoint.getSignature().getName();
		System.out.println("The afterlogging method "+methodName+" end");
	}
	
	public void afterreturninglogging(JoinPoint joinPoint,Object result){
		String methodName = joinPoint.getSignature().getName();
		System.out.println("The afterreturninglogging method "+methodName+" end with "+result);
		
	}
	public void afterthrowinglogging(JoinPoint joinPoint, Exception ex){
		String methodName = joinPoint.getSignature().getName();
		System.out.println("The afterthrowinglogging method "+methodName+" occurs excetion: "+ex);
		
	}
	
	
	/*	public Object aroundlogging(ProceedingJoinPoint pjd){
		Object result =null;
		String methodName = pjd.getSignature().getName();
		  List<Object> args = Arrays.asList(pjd.getArgs()); 
		
		try {
			// ǰ��֪ͨ
			
			System.out.println("The aroundlogging methor"+ methodName+" begin with"+args);
			result = pjd.proceed();
			// ����֪ͨ
			System.out.println("The aroundlogging method "+methodName+" end with "+result);
			
		} catch (Throwable e) {
			System.out.println("The aroundlogging method "+methodName+" occurs excetion: "+e);
			// �쳣֪ͨ
			e.printStackTrace();
		}
		//����֪ͨ
		System.out.println("The aroundlogging method "+methodName+" end");
		return 100;
	}
	
	*/
	
	
}
