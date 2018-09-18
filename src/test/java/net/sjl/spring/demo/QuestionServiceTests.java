package net.sjl.spring.demo;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import net.sjl.spring.demo.domain.entity.Question;
import net.sjl.spring.demo.domain.service.QuestionService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class QuestionServiceTests {
	
	@Autowired
	private QuestionService service;

	@Test
	public void contextLoads() {
	}
	
	@Test
	public void save() {
		
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
		
		question1 = service.upSert(question1);
		question2 = service.upSert(question2);
		
		assertNotNull(question1);
		assertNotNull(question2);
	}
	
	@Test
	public void queryById() {
		Question question = service.retrieveQuestionWithId(102);
		System.out.println("question is " + question.toString());
	}
	
	@Test
	public void queryByPassageId() {
		Question question = service.retrieveQuestionWithPassageId(104);
		System.out.println("question is " + question.toString());
	}

}
