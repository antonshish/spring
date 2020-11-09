package ru.home.springdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("TennisCoach")
@Scope("singleton")
public class TennisCoach implements Coach {
	
	@Autowired
	@Qualifier("randomFortuneService")
	private FortuneService fortuneService;
	
	// чтобы посмотреть
	public TennisCoach() {
		System.out.println("inside constructor");
	}
	
	
	@Autowired
	@Qualifier("happyFortuneService")
	public void anyMethodName(FortuneService fs) {
		System.out.println("inside method");
		//fortuneService = fs;
	}
	
	
	
	/*@Autowired //Spring автоматически найдет в контексте и вставит FortuneSevice
	public TennisCoach(FortuneService fortuneSevice) {
		this.fortuneService = fortuneSevice;
	}*/

	@Override
	public String getDailyWorkout() {
		
		return "Tennis coach dealy workout";
	}

	@Override
	public String getDailyFortune() {
		
		return fortuneService.getFortune();
	}

}
