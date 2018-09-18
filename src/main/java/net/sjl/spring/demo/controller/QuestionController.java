package net.sjl.spring.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import net.sjl.spring.demo.domain.entity.Question;
import net.sjl.spring.demo.domain.service.QuestionService;

@RestController
@Api(value = "Quiz REST API", tags = {"quiz"})
public class QuestionController {
	
	@Autowired
	QuestionService service;
	
	@ApiOperation(value = "Retrieve Question By Passage Id")
	@RequestMapping(method = RequestMethod.GET, value = "/api/questions/passage/{passageId}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE )
    @ApiResponses(value = {@ApiResponse(code = 404, message = "The requested question is not found.")})
    public ResponseEntity<Question> getQuestionByPassageId(@PathVariable("passageId") @ApiParam(value = "Passage Id", required = true) int passageId) {
		Question question = service.retrieveQuestionWithPassageId(passageId);
        
        return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON_UTF8).body(question);
    } 

}
