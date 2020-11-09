package com.luv2code.aopdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.luv2code.aopdemo.dao.AccountDAO;
import com.luv2code.aopdemo.dao.MembershipDAO;

public class MainDemoApp {

	public static void main(String[] args) {
		
		AnnotationConfigApplicationContext context =
				new AnnotationConfigApplicationContext(DemoConfig.class);
		
		AccountDAO dao = context.getBean("accountDAO", AccountDAO.class);
		
		MembershipDAO dao1 = context.getBean("membershipDAO", MembershipDAO.class);
		
		dao.addAccount(new Account(), true);
		dao.doWork();
		dao.setName("aa");
		dao.getName();
		
		System.out.println("///////");
		
		dao1.addAccount();
		dao1.goToSleep();
		
		context.close();
	}

}
