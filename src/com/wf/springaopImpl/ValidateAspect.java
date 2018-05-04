package com.wf.springaopImpl;

import java.util.Arrays;
import java.util.List;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Order(0)
@Aspect
@Component
public class ValidateAspect {

	// ����һ����������������������ʽ,Ȼ�����������뷽�������ɣ�
	//�������ǿ�������ValidateAspect.declareJoinPointExpression()���п�������
	@Pointcut(value="execution(public int com.wf.springaopImpl.ArithmeticCalculatorImpl.*(int , int))")
	public void declareJoinPointExpression(){
	} 	
	
	
	@Before("declareJoinPointExpression()")
	public void brforeValidate(JoinPoint joinPoint){ //ע�� JoinPoint �İ�		
		String methodName = joinPoint.getSignature().getName();
		List<Object> args = Arrays.asList(joinPoint.getArgs());
		
		System.out.println("----------The Validate methor"+ methodName+" begin with"+args);
		
	}
	
	@After("declareJoinPointExpression()")
	public void afterValidate(JoinPoint joinPoint){
		String methodName = joinPoint.getSignature().getName();
		System.out.println("The afterValidate method "+methodName+" end");
	}
	
}
