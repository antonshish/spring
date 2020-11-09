package com.luv2code.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(1)
public class MyCloudLog {
	
	@Before("com.luv2code.aopdemo.aspect.AopExpressions.withoutGetterAndSetter()")
	public void logToCloudAsunc() {
		System.out.println("\n====>>>Execution Logging to cloud");
	}

}
