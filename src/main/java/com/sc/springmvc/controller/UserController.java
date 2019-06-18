package com.sc.springmvc.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sc.springmvc.pojo.Student;
import com.sc.springmvc.pojo.User;
import com.sc.springmvc.service.inf.UserService;

@Controller
public class UserController {

	@Autowired
	private UserService userService;
	
	@RequestMapping("/showUser")
	public String toIndex(HttpServletRequest request, Model model) {
		Integer user_id = Integer.parseInt(request.getParameter("id"));
		User user = this.userService.findUserById(user_id);
		model.addAttribute("user", user);
		
		return "showUser";
	}
	
	/**
	 * ”√ªßµ«¬Ω
	 */
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(String user_name, String password, Model model, HttpSession session) {
		
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("user_name1", user_name);
		param.put("password1", password);
		this.userService.findUser(param);
		List<User> userList = (List<User>) param.get("result");
		User user = userList.get(0);
		if(user != null) {
			session.setAttribute("USER_SESSION", user);
			return "studentRegister";
		}
		model.addAttribute("msg", "’ÀªßªÚ√‹¬Î¥ÌŒÛ");
		return "login";
	}
	
	@RequestMapping(value = "/toRegister", method = RequestMethod.POST)
	public String toRegister(HttpServletRequest request, Model model) {
		return "register";
	}
	
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String userRegister(User user, Model model, HttpSession session) {
		
		user.setUser_type('N');
		user.setSts('A');
		userService.addUser(user);
	
		System.out.println(user.getUser_id());
		
		session.setAttribute("USER_SESSION", user);
		return "studentRegister";
	}
	
	@RequestMapping(value = "/toLogin", method = RequestMethod.POST)
	public String toLogin(Model model, HttpSession session) {
		return "login";
	}
	
}
