package ru.home.springdemo;

import org.springframework.stereotype.Component;

@Component
public class HappyFortuneService implements FortuneService {


	@Override
	public String getFortune() {
		// TODO Auto-generated method stub
		return "from happy fortune";
	}

}
