package net.sjl.spring.demo.domain.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import net.sjl.spring.demo.domain.entity.Question;

public interface QuestionRepository extends CrudRepository<Question, Long> {
	
	public List<Question> findByPassageId(int passageId);

}
