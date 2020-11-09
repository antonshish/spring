package com.luv2code.aopdemo.dao;

import org.springframework.stereotype.Component;

import com.luv2code.aopdemo.Account;

@Component
public class AccountDAO {
	
	public void addAccount(Account acc, boolean flag) {
		System.out.println("Doing db work");
	}
	
	public boolean doWork() {
		System.out.println(getClass() + " doWork()");
		
		return true;
	}
	
}
