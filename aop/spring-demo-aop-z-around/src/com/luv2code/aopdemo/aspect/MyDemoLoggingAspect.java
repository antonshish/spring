package com.luv2code.aopdemo.aspect;

import java.util.List;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.luv2code.aopdemo.Account;

@Aspect
@Component
@Order(2)
public class MyDemoLoggingAspect {
	@Around("execution(* com.luv2code.aopdemo.service.*.getFortune(..))")
	public Object aroundGetFortune(
			ProceedingJoinPoint pjp) throws Throwable {
		
		String method = pjp.getSignature().toShortString();
		System.out.println("\n===>> Executiong @After(Finally): " + method);
		
		long begin = System.currentTimeMillis();
		
		Object result = pjp.proceed();
		
		long end = System.currentTimeMillis();
		
		long duration = end - begin;
		System.out.println("\n=====> Duration: " + duration/1000.0 + "seconds");
		
		return result;
	}
	
	@After("execution(* com.luv2code.aopdemo.dao.AccountDAO.findAccounts(..))")
	public void afterFinallyAdvice(JoinPoint jp) {
		String method = jp.getSignature().toShortString();
		System.out.println("\n===>> Executiong @After(Finally): " + method);
		
	}
	
	@AfterThrowing(
			pointcut="execution(* com.luv2code.aopdemo.dao.AccountDAO.findAccounts(..))",
			throwing="Exc")
	public void afterThrowingFindAccountAdvice(
			JoinPoint jp, Throwable Exc) {
		System.out.println("\n====>>>Execution @AfterThrowing advice on method addAccount");
		MethodSignature sig = (MethodSignature) jp.getSignature();
		
		//display the method signature
		System.out.println("Method: " + sig);
		System.out.println("\n " + Exc);
		
	}
	
	@AfterReturning(
			pointcut="execution(* com.luv2code.aopdemo.dao.AccountDAO.findAccounts(..))",
			returning="result")
	public void afterReturningAdvice(JoinPoint jp, List<Account> result) {
		
		String method = jp.getSignature().toShortString();
		System.out.println("\n===>> Executiong @AfterReturning: " + method);
		System.out.println("\n===>> result is: " + result);
		
		//post-process the data
		
		convertAccountNamesToUpperCase(result);
		
	}
	
	private void convertAccountNamesToUpperCase(List<Account> result) {
		
		for(Account acc : result) {
			String upperName = acc.getName().toUpperCase();
			acc.setName(upperName);
		}
		
	}

	@Before("com.luv2code.aopdemo.aspect.AopExpressions.withoutGetterAndSetter()")
	public void AddAccountAdvice(JoinPoint jp) {
		System.out.println("\n====>>>Execution @Before advice on method addAccount");
		MethodSignature sig = (MethodSignature) jp.getSignature();
		
		//display the method signature
		System.out.println("Method: " + sig);
		
		//display method args
		
		Object[] args = jp.getArgs();
		
		for(Object arg : args) {
			System.out.println(arg);
		}
		
	}

}
