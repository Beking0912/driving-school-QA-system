package com.sc.springmvc.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.sc.springmvc.dao.StudentDao;
import com.sc.springmvc.pojo.Student;
import com.sc.springmvc.service.inf.StudentService;

@Service("studentService")
public class StudentServiceImpl implements StudentService {

	@Resource
	private StudentDao studentDao;
	
	@Override
	public List<Student> findStudent(Map<String, Object> param) {
		// TODO Auto-generated method stub
		List<Student> student = studentDao.findStudent(param);
		return student;
	}

	@Override
	public int addStudent(Student student) {
		// TODO Auto-generated method stub
		return this.studentDao.addStudent(student);
	}

}
