package com.luv2code.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLiggingAspect {
	
	//this is where we add all of out related advices for logging
	
	//@Before("execution(* add*(com.luv2code.aopdemo.Account, ..))") 
	//@Before("execution(* add*(..))") 
	//@Before("execution(* com.luv2code.aopdemo.dao.*.add*(..))") 
	@Before("execution(* com.luv2code.aopdemo.dao.*.*(..))")
	public void AddAccountAdvice() {
		System.out.println("\n====>>>Execution @Before advice on method addAccount");
	}

}
