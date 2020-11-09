package com.luv2code.aopdemo.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.luv2code.aopdemo.Account;

@Component
public class AccountDAO {
	
	private String name;
	
	private String serviceCode;
	
	public List<Account> findAccounts(boolean flag) {
		
		if(flag) {
			throw new RuntimeException();
		}
		List<Account> myAccounts = new ArrayList<>();
		
		Account a1 = new Account ("John", "1");
		Account a2 = new Account ("Kek", "2");	
		Account a3 = new Account ("Aaa", "3");
		
		myAccounts.add(a1);
		myAccounts.add(a2);
		myAccounts.add(a3);
		return myAccounts;
	}
	
	
	public void addAccount(Account acc, boolean flag) {
		System.out.println("Doing db work");
	}
	
	public boolean doWork() {
		System.out.println(getClass() + " doWork()");
		
		return true;
	}

	public String getName() {
		System.out.println(getClass() + " getName()");
		return name;
	}

	public void setName(String name) {
		System.out.println(getClass() + " setName()");
		this.name = name;
	}

	public String getServiceCode() {
		return serviceCode;
	}

	public void setServiceCode(String serviceCode) {
		this.serviceCode = serviceCode;
	}
	
	
	
}
