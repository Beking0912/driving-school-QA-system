package com.sc.springmvc.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sc.springmvc.pojo.Student;
import com.sc.springmvc.pojo.User;
import com.sc.springmvc.service.inf.StudentService;

@Controller
public class StudentController {

	@Autowired
	private StudentService studentService;
	
	/**
	 * øº…˙◊¢≤·
	 */
	@RequestMapping(value = "/studentRegister", method = RequestMethod.POST)
	public String studentRegister(Student student, Model model, HttpSession session) {
		studentService.addStudent(student);
		if(student.getId() != null) {
			session.setAttribute("STUDENT_SESSION", student);
			System.out.println(student.getId());
			System.out.println(student.getName());
			
			return "studentTestList";
		}
		model.addAttribute("msg", "’ÀªßªÚ√‹¬Î¥ÌŒÛ");
		return "login";
	}
	
	@RequestMapping(value = "/toStudentTest", method = RequestMethod.POST)
	public String toStudentTest() {
		System.out.println("go to test");
		return "studentTest";
	}
	
}
