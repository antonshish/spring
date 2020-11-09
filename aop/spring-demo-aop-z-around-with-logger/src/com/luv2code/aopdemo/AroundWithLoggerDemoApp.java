package com.luv2code.aopdemo;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.luv2code.aopdemo.dao.AccountDAO;
import com.luv2code.aopdemo.service.TrafficFortuneService;

public class AroundWithLoggerDemoApp {
	private static Logger myLogger = 
			Logger.getLogger(AroundWithLoggerDemoApp.class.getName());
	public static void main(String[] args) {
		
		
		
		AnnotationConfigApplicationContext context =
				new AnnotationConfigApplicationContext(DemoConfig.class);
		
		TrafficFortuneService fortune = context.getBean("trafficFortuneService", TrafficFortuneService.class);
		
		myLogger.info(fortune.getFortune());
		
		context.close();
	}

}
;