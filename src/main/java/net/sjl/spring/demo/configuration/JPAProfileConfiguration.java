package net.sjl.spring.demo.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import net.sjl.spring.demo.domain.repository.QuestionRepository;
import net.sjl.spring.demo.port.adapter.persistence.jpa.QuestionJPARepository;

@Configuration
@Profile("JPA")
public class JPAProfileConfiguration {
	
	@Autowired
	private QuestionJPARepository questionRepository;
	
	@Bean("questionRepository")
	public QuestionRepository questionJPARepository() {
		System.out.println("JPA questionRepository");
		return questionRepository;
	}

}
