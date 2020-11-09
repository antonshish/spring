package com.luv2code.aopdemo.aspect;

import java.util.List;
import java.util.logging.Logger;

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
	
	private Logger logger = Logger.getLogger(getClass().getName());
	@Around("execution(* com.luv2code.aopdemo.service.*.getFortune(..))")
	public Object aroundGetFortune(
			ProceedingJoinPoint pjp) throws Throwable {
		
		String method = pjp.getSignature().toShortString();
		logger.info("\n===>> Executiong @After(Finally): " + method);
		
		long begin = System.currentTimeMillis();
		Object result = null;
		try {
			result = pjp.proceed();
		} catch(Exception e) {
			logger.warning(e.getMessage());
			result = "from try-catch";
			throw e;
		}
		
		long end = System.currentTimeMillis();
		
		long duration = end - begin;
		logger.info("\n=====> Duration: " + duration/1000.0 + "seconds");
		
		return result;
	}
	
	@After("execution(* com.luv2code.aopdemo.dao.AccountDAO.findAccounts(..))")
	public void afterFinallyAdvice(JoinPoint jp) {
		String method = jp.getSignature().toShortString();
		logger.info("\n===>> Executiong @After(Finally): " + method);
		
	}
	
	@AfterThrowing(
			pointcut="execution(* com.luv2code.aopdemo.dao.AccountDAO.findAccounts(..))",
			throwing="Exc")
	public void afterThrowingFindAccountAdvice(
			JoinPoint jp, Throwable Exc) {
		logger.info("\n====>>>Execution @AfterThrowing advice on method addAccount");
		MethodSignature sig = (MethodSignature) jp.getSignature();
		
		//display the method signature
		logger.info("Method: " + sig);
		logger.info("\n " + Exc);
		
	}
	
	@AfterReturning(
			pointcut="execution(* com.luv2code.aopdemo.dao.AccountDAO.findAccounts(..))",
			returning="result")
	public void afterReturningAdvice(JoinPoint jp, List<Account> result) {
		
		String method = jp.getSignature().toShortString();
		logger.info("\n===>> Executiong @AfterReturning: " + method);
		logger.info("\n===>> result is: " + result);
		
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
		logger.info("\n====>>>Execution @Before advice on method addAccount");
		MethodSignature sig = (MethodSignature) jp.getSignature();
		
		//display the method signature
		logger.info("Method: " + sig);
		
		//display method args
		
		Object[] args = jp.getArgs();
		
		for(Object arg : args) {
			logger.info(arg.toString());
		}
		
	}

}
