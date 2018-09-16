package net.sjl.spring.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.sjl.spring.demo.entity.Question;
import net.sjl.spring.demo.repository.QuestionRepository;

@Service
public class QuestionService {
	
	@Autowired
	private QuestionRepository repository;
	
	public Question retrieveQuestion(int passageId) {
		return repository.findByPassageId(passageId).get(0);
	}

}
