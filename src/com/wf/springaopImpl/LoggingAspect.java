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

	// ǰ��֪ͨ�� ��Ŀ�� ������ʼ֮ǰ����ִ�е�֪ͨ
	@Before( "ValidateAspect.declareJoinPointExpression()")
//	@Before( "execution(public int com.wf.springaopImpl.ArithmeticCalculatorImpl.*(int , int))")
	public void brforelogging(JoinPoint joinPoint){ //ע�� JoinPoint �İ�		
		String methodName = joinPoint.getSignature().getName();
		List<Object> args = Arrays.asList(joinPoint.getArgs());
		
		System.out.println("The brforelogging methor"+ methodName+" begin with"+args);
		
	}
	// ����֪ͨ�� ��Ŀ�귽��ִ��֮�������Ƿ����쳣��������ִ�е�֪ͨ
	//�ں���֪ͨ�У����ܷ���Ŀ�귽����ִ�н��
//	@After("execution(public int com.wf.springaopImpl.ArithmeticCalculatorImpl.*(int , int)))")
	public void afterlogging(JoinPoint joinPoint){
		String methodName = joinPoint.getSignature().getName();
		System.out.println("The afterlogging method "+methodName+" end");
	}
	
	/**
	 * ����֪ͨ�� ��Ŀ�귽����������ʱ����ִ�е�֪ͨ
	 * 
	 * ����֪ͨ���Է��ʵ������ķ���ֵ
	 * 	 */
//	@AfterReturning(value="execution(public int com.wf.springaopImpl.ArithmeticCalculatorImpl.*(int , int)))",returning="result")
	public void afterreturninglogging(JoinPoint joinPoint,Object result){
		String methodName = joinPoint.getSignature().getName();
		System.out.println("The afterreturninglogging method "+methodName+" end with "+result);
		
	}
	
	/*
	 * �쳣֪ͨ ����Ŀ�귽�������쳣ʱ�Ż����ִ�еĴ���
	 * 
	 * ���Է��ʵ��쳣����Exception��������ָ��Ϊ�ض����쳣 ����NullPointerException��
	 * 
	 * */
	
	@AfterThrowing(value="execution(public int com.wf.springaopImpl.ArithmeticCalculatorImpl.*(int , int)))",throwing="ex")
	public void afterthrowinglogging(JoinPoint joinPoint, Exception ex){
		String methodName = joinPoint.getSignature().getName();
		System.out.println("The afterthrowinglogging method "+methodName+" occurs excetion: "+ex);
		
	}
	
	
	
		/*
		 * 
		 * ����֪ͨ
		 * 
		 * ����֪ͨ��Ҫָ������ProceedingJoinPoint���������
		 * ����֪ͨ�����ڶ�̬�����ȫ���̣�ProceedingJoinPoint ���͵Ĳ������Ծ����Ƿ�ִ��Ŀ�귽��
		 * ����֪ͨ������ڷ���ֵ������ֵ��ΪĿ�귽���ķ���ֵ��
		 * ����֪ͨ�Ĵ��ڻᵼ��ǰ��֪ͨ���쳣֪ͨ������ִ�У��ҿ��ܻᵼ�·���֪ͨ���صĽ��ʧ��
		 * 
		 * */
	@Around(value="execution(public int com.wf.springaopImpl.ArithmeticCalculatorImpl.*(int , int)))")
	public Object aroundlogging(ProceedingJoinPoint pjd){
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


	
	
}
