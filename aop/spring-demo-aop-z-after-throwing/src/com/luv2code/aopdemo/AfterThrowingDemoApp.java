package com.luv2code.aopdemo;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.luv2code.aopdemo.dao.AccountDAO;

public class AfterThrowingDemoApp {

	public static void main(String[] args) {
		
		AnnotationConfigApplicationContext context =
				new AnnotationConfigApplicationContext(DemoConfig.class);
		
		AccountDAO dao = context.getBean("accountDAO", AccountDAO.class);
		List<Account> accs = null;
		try {
			boolean flag = true;
			accs = dao.findAccounts(flag);
		
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		System.out.println("\n\n Main:");
		System.out.println("---");
		System.out.println(accs);
		System.out.println("\n");
		
		context.close();
	}

}
