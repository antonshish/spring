package com.luv2code.aopdemo.aspect;

import org.aspectj.lang.JoinPoint; 
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(2)
public class MyDemoLoggingAspect {
	
	@Before("com.luv2code.aopdemo.aspect.AopExpressions.withoutGetterAndSetter()")
	public void AddAccountAdvice(JoinPoint jp) {
		System.out.println("\n====>>>Execution @Before advice on method addAccount");
		MethodSignature sig = (MethodSignature) jp.getSignature();
		
		//display the method signature
		System.out.println("Method: " + sig);
		
		//display method args (переданные внутрь)
		
		Object[] args = jp.getArgs();
		
		for(Object arg : args) {
			System.out.println(arg);
		}
		
	}

}
