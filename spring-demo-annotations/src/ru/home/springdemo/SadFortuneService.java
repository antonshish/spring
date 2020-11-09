package ru.home.springdemo;

public class SadFortuneService implements FortuneService {

	@Override
	public String getFortune() {
		
		return "from sad fortuneService";
	}

}
