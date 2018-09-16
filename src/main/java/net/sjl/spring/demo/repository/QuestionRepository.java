package net.sjl.spring.demo.repository;

import java.util.List;

import net.sjl.spring.demo.entity.Question;

public interface QuestionRepository {
	
	public List<Question> findByPassageId(int passageId);

}
