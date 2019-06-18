package com.sc.springmvc.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sc.springmvc.pojo.Paper;
import com.sc.springmvc.pojo.Question;
import com.sc.springmvc.pojo.Student;
import com.sc.springmvc.service.inf.QuestionService;

import oracle.jdbc.OracleTypes;

@Controller
public class QuestionController {

	@Autowired
	private QuestionService questionService;
	
	
	//随机生成10道题，并生成试卷，生成准考证
	@RequestMapping("/queryQuestion")
	public String showQuestion(Model model, HttpSession session) {
		
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("n", 10);
		this.questionService.randomFind10Question(param);
		
		List<Question> questionList = (List<Question>) param.get("result");
		for(Question q:questionList) {
			System.out.println(q.getQuestion_id() + " " + q.getQuestion_body());
		}
		model.addAttribute("questionList", questionList);
		session.setAttribute("questionList", questionList);
		
		//生成准考证
		Date currentTime = new Date(); 
		SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd");
		String s8 = formatter.format(currentTime);
		System.out.println(s8);
				
		Student student = (Student) session.getAttribute("STUDENT_SESSION");
		//准考证号stu_test_id
		String stu_test_id = student.getId().toString() + s8;
		session.setAttribute("stu_test_id", stu_test_id);
				
		System.out.println(stu_test_id);
		
		return "studentTestCheck";
	}
	
}
