package com.luv2code.aopdemo.aspect;

import java.util.List;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
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
