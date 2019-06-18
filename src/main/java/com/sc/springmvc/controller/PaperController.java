package com.sc.springmvc.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sc.springmvc.pojo.Paper;
import com.sc.springmvc.pojo.Question;
import com.sc.springmvc.pojo.Student;
import com.sc.springmvc.service.inf.PaperService;

@Controller
public class PaperController {

	@Autowired
	private PaperService paperService;
	
	@RequestMapping(value = "/createPaper", method = RequestMethod.POST)
	public String createPaper(Paper paper, Model model, HttpSession session) {
		
		String question_id_seq = "";
		String key_seq = "";
		
		List<Question> questionList = (List<Question>) session.getAttribute("questionList");
		for(Question q:questionList) {
			question_id_seq = question_id_seq + q.getQuestion_id() + ",";
			key_seq = key_seq + q.getQuestion_key() + ",";
		}
		System.out.println(question_id_seq);
		paper.setQuestion_id_seq(question_id_seq);
		paper.setKey_seq(key_seq);
		
		paperService.addPaper(paper);
		if (paper != null) {
			session.setAttribute("paper", paper);
		}
		
		
		return "studentTest";
	}
	
	public Paper findPaper(Map<String, Object> param2) {
		this.paperService.findPaper(param2);
		System.out.println(param2);
		List<Paper> paperList =  (List<Paper>) param2.get("result");
		Paper paper = paperList.get(0);
		//System.out.println(paper);
		
		return paper;
	}
}
