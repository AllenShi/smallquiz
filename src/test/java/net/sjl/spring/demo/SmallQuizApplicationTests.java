package net.sjl.spring.demo;

import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Example;
import org.springframework.test.context.junit4.SpringRunner;

import net.sjl.spring.demo.entity.Question;
import net.sjl.spring.demo.repository.QuestionRepository;
import net.sjl.spring.demo.repository.adapter.mongo.QuestionMongoRepository;
import net.sjl.spring.demo.service.QuestionService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SmallQuizApplicationTests {
	
	@Autowired
	private QuestionService service;
	
	@Autowired
	private QuestionMongoRepository repository;

	@Test
	public void contextLoads() {
	}
	
	@Test
	public void save() {
		repository.deleteById(Long.valueOf(102));
		repository.deleteById(Long.valueOf(103));
		
		Question question1 = new Question();
		question1.setId(102);
		question1.setPassageId(102);
		question1.setAnalysis("test1");
		question1.setOrder(2);
		question1.setStem("stem2");
		question1.setRightAnswer('C');
	
		Question question2 = new Question();
		question2.setId(103);
		question2.setPassageId(103);
		question2.setAnalysis("test1");
		question2.setOrder(2);
		question2.setStem("stem2");
		question2.setRightAnswer('C');
		
		repository.save(question1);
		repository.save(question2);
	}
	
	@Test
	public void queryByPassageId() {
		Question question = service.retrieveQuestion(104);
		System.out.println("question is " + question);
	}
	
	@Test
	public void queryOne() {
		Question question1 = new Question();
		question1.setId(102);
		question1.setPassageId(102);
		question1.setAnalysis("test1");
		question1.setOrder(2);
		question1.setStem("stem2");
		question1.setRightAnswer('C');
		Optional<Question> question = repository.findOne(Example.of(question1));
		if(question.isPresent()) {
			System.out.println("question is " + question.get());
		}
		
		Question question2 = new Question();
		question2.setId(103);
		question2.setPassageId(103);
		question2.setAnalysis("test1");
		question2.setOrder(2);
		question2.setStem("stem2");
		question2.setRightAnswer('C');
		question = repository.findOne(Example.of(question2));
		if(question.isPresent()) {
			System.out.println("question is " + question.get());
		}
	}

}
