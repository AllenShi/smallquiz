package net.sjl.spring.demo.domain.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import net.sjl.spring.demo.domain.entity.Question;
import net.sjl.spring.demo.domain.repository.QuestionRepository;

@Service
public class QuestionService {
	
	@Autowired
	@Qualifier("questionRepository")
	private QuestionRepository repository;
	
	// @Cacheable(value = "questions", key = "#questionId")
	public Question retrieveQuestionWithId(long questionId) {
		Optional<Question> questionOpt = repository.findById(Long.valueOf(questionId));
		if(questionOpt.isPresent()) {
			return questionOpt.get();
		}
		
		return null;
	}
	
	// @Cacheable(value = "questionsByPassageId", key = "#passageId")
	public Question retrieveQuestionWithPassageId(int passageId) {
		return repository.findByPassageId(passageId).get(0);
	}
	
	// @CachePut(value = "questions", key = "#question.id")
	// @CacheEvict(value = "questionsByPassageId", allEntries=true)
	public Question upSert(Question question) {
		return repository.save(question);
	}

}
