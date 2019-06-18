package com.sc.springmvc.service.inf;

import java.util.List;
import java.util.Map;

import com.sc.springmvc.pojo.Student;

public interface StudentService {

	/**
	 *  通过id查找考生 
	 */
	public List<Student> findStudent(Map<String, Object> param);
	
	/**
	 *  新增考生 
	 */
	public int addStudent(Student student);
	
	
}
