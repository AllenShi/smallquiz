package net.sjl.spring.demo;

import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import net.sjl.spring.demo.domain.entity.Question;
import net.sjl.spring.demo.domain.repository.QuestionRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProfiledQuestionRepositoryTests {
	
	@Autowired
	@Qualifier("questionRepository")
	private QuestionRepository repository;

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
	public void queryById() {
		Optional<Question> questionOpt = repository.findById(Long.valueOf(103));
		
		if(questionOpt.isPresent()) {
		  System.out.println("question is " + questionOpt.get().toString());
		}
	}


}
