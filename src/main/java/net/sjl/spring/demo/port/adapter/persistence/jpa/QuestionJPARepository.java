package net.sjl.spring.demo.port.adapter.persistence.jpa;

import org.springframework.context.annotation.Profile;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import net.sjl.spring.demo.domain.entity.Question;
import net.sjl.spring.demo.domain.repository.QuestionRepository;

@Repository
@Profile("JPA")
public interface QuestionJPARepository extends PagingAndSortingRepository<Question, Long>, QuestionRepository {

}
