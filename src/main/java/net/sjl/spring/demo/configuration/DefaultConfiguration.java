package net.sjl.spring.demo.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import net.sjl.spring.demo.domain.repository.QuestionRepository;
import net.sjl.spring.demo.port.adapter.persistence.mongo.QuestionMongoRepository;

@Configuration
public class DefaultConfiguration {
	
	@Autowired
	private QuestionMongoRepository questionRepository;
	
	@Bean("questionRepository")
	public QuestionRepository questionMongoRepository() {
		System.out.println("Mongo questionRepository");
		return questionRepository;
	}
	
}
