package net.sjl.spring.demo.port.adapter.persistence.redis;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import net.sjl.spring.demo.domain.entity.Question;
import net.sjl.spring.demo.domain.repository.QuestionRepository;

@Repository
public interface QuestionRedisRepository extends CrudRepository<Question, Long>, QuestionRepository {

}
