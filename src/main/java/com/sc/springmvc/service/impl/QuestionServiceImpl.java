package com.sc.springmvc.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sc.springmvc.dao.QuestionDao;
import com.sc.springmvc.pojo.Question;
import com.sc.springmvc.service.inf.QuestionService;

@Service("questionService")
public class QuestionServiceImpl implements QuestionService {

	@Autowired
	private QuestionDao questionDao;
	
	@Override
	public List<Question> randomFind10Question(Map<String, Object> param) {
		// TODO Auto-generated method stub
		List<Question> questionList = questionDao.randomFind10Question(param);
		return questionList;
	}

	public List<Question> findQuestionbyId(Map<String, Object> param) {
		List<Question> question = questionDao.findQuestionbyId(param);
		
		return question;
	}
	
}
