package com.luv2code.aopdemo.dao;

import org.springframework.stereotype.Component;

@Component
public class MembershipDAO {
	
	public void addAccount() {
		System.out.println(getClass() + " doing stuff");
	}
	
	
	public void goToSleep() {
		
		System.out.println("goToSleep");
	}
}
