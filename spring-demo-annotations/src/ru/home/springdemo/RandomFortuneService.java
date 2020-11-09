package ru.home.springdemo;

import java.util.Random;

import org.springframework.stereotype.Component;

@Component
public class RandomFortuneService implements FortuneService {
	
	private String[] data = {
			"random1",
			"random2",
			"random3"
	};
	
	private Random myRandom = new Random();
	
	
			
	@Override
	public String getFortune() {
		int index = myRandom.nextInt(data.length);
		String result = data[index];
		return result;
	}

}
