package net.sjl.spring.demo.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;

import net.sjl.spring.demo.domain.repository.QuestionRepository;
import net.sjl.spring.demo.port.adapter.persistence.jpa.QuestionJPARepository;
import net.sjl.spring.demo.port.adapter.persistence.redis.QuestionRedisRepository;

@Configuration
@Profile("Redis")
public class RedisProfileConfiguration {
	
	@Autowired
	private QuestionRedisRepository questionRepository;
	
	@Bean("questionRepository")
	public QuestionRepository questionRedisRepository() {
		System.out.println("Redis questionRepository");
		return questionRepository;
	}

	@Bean
	JedisConnectionFactory jedisConnectionFactory() {
		RedisStandaloneConfiguration redisStandaloneConfiguration = new RedisStandaloneConfiguration("localhost", 6379);
	    // redisStandaloneConfiguration.setPassword(RedisPassword.of("yourRedisPasswordIfAny"));
		return new JedisConnectionFactory(redisStandaloneConfiguration);
	}
	 
	@Bean
	public RedisTemplate<String, Object> redisTemplate() {
	    RedisTemplate<String, Object> template = new RedisTemplate<>();
	    template.setConnectionFactory(jedisConnectionFactory());
	    return template;
	}
	
}
