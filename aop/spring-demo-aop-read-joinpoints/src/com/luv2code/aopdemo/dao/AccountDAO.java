package com.luv2code.aopdemo.dao;

import org.springframework.stereotype.Component;

import com.luv2code.aopdemo.Account;

@Component
public class AccountDAO {
	
	private String name;
	
	private String serviceCode;
	
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
