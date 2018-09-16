package net.sjl.spring.demo.repository.adapter.mongo;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import net.sjl.spring.demo.entity.Question;
import net.sjl.spring.demo.repository.QuestionRepository;

@Repository
public interface QuestionMongoRepository extends MongoRepository<Question, Long>, QuestionRepository {

}
