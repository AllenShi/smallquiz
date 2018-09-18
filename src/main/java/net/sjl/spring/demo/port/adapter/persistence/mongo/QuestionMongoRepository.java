package net.sjl.spring.demo.port.adapter.persistence.mongo;

import org.springframework.context.annotation.Primary;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import net.sjl.spring.demo.domain.entity.Question;
import net.sjl.spring.demo.domain.repository.QuestionRepository;

@Repository
@Primary
public interface QuestionMongoRepository extends MongoRepository<Question, Long>, QuestionRepository {

}
