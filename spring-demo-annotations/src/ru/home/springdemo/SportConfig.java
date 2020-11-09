package ru.home.springdemo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
//@ComponentScan("ru.home.springdemo") можно указать папку
// а можно сделать так, как ниже

@PropertySource("classpath:sport.properties") //для заполенения полей из файла

public class SportConfig {
	
	
	
	//define bean for out sad fortune service
	@Bean // имя метода соответствует beanId
	public FortuneService sadFortuneService() {
		return new SadFortuneService();
	}
	
	
	// define bean for out swim coach and inject dependency
	@Bean
	public Coach swimCoach() {
		return new SwimCoach(sadFortuneService());
	}


	

}
