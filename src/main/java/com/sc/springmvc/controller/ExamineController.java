package com.sc.springmvc.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sc.springmvc.pojo.Examine;
import com.sc.springmvc.pojo.Paper;
import com.sc.springmvc.pojo.Student;
import com.sc.springmvc.service.impl.PaperServiceimpl;
import com.sc.springmvc.service.impl.QuestionServiceImpl;
import com.sc.springmvc.service.inf.ExamineService;
import com.sc.springmvc.service.inf.PaperService;
import com.sc.springmvc.service.inf.QuestionService;

@Controller
public class ExamineController {

	@Autowired
	private ExamineService examineService;
	
	@RequestMapping(value = "/submitExamine", method = RequestMethod.POST)
	public String submitExamine(Examine examine, Model model, HttpSession session, HttpServletRequest request) {
		
		Integer score = 0;
		
		Student student = (Student) session.getAttribute("STUDENT_SESSION");
		String stu_test_id = (String) session.getAttribute("stu_test_id");
		
		Paper paper = (Paper) session.getAttribute("paper");
		List<String> keyList = Arrays.asList(paper.getKey_seq().split(","));
		
		List<String> answerList = new ArrayList<String>();
		String answer_seq = "";
		for(int i=1; i<=10; i++) {
			String answer = (String) request.getParameter("subjectAnswer="+i);
			answerList.add(answer);
			answer_seq = answer_seq + answer + ",";
			
			if(keyList.get(i-1).equals(answer) ) {
				score += 10;
				//System.out.println(keyList.get(i-1));
				//System.out.println(answer);
				//System.out.println(score);
			}
			
		}
		
		examine.setEm_in(stu_test_id);
		examine.setEm_pwd("123456");
		examine.setStudent(student.getId());
		examine.setAnswer(answer_seq);
		examine.setScore(score);
		examine.setPaper_id(paper.getPaper_id());
		examine.setEm_date(new Date());
		examine.setStatus('A');
		
		System.out.println(paper.getPaper_id());
		
		session.setAttribute("examine", examine);
		
		examineService.addExamine(examine);
		
		return "studentTestResult";
	}
	
	@RequestMapping(value = "/checkResult", method = RequestMethod.POST)
	public String checkResult(Examine examine, Model model, HttpSession session, HttpServletRequest request) {
		return "studentTestResultDetail";
	}
	
	@RequestMapping(value = "/searchResult", method = RequestMethod.POST)
	public String searchResult(Examine examine, Model model, HttpSession session, HttpServletRequest request) {
		
		Map<String, Object> param1 = new HashMap<String, Object>();
		System.out.println(examine.getEm_in());
		param1.put("em_in", examine.getEm_in());
		this.examineService.findExamine(param1);
		
		List<Examine> examineList = (List<Examine>) param1.get("result");
		
		examine = examineList.get(0);
		
		session.setAttribute("examine", examine);
		
		PaperController paperController = new PaperController();
		
		PaperService paperService = new PaperServiceimpl();
		Map<String, Object> param2 = new HashMap<String, Object>();
		param2.put("paper_id", examine.getPaper_id());
		Paper paper = paperController.findPaper(param2);
		
		System.out.println(paper.getPaper_id());
		
		
		QuestionService questionService = new QuestionServiceImpl();
		
		Map<String, Object> param3 = new HashMap<String, Object>();
		param3.put("n", 10);
		questionService.randomFind10Question(param3);
		
		
		return "studentTestResultDetail";
	}
	
}
