package com.sc.springmvc.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.sc.springmvc.pojo.Student;
import com.sc.springmvc.pojo.User;

public interface StudentDao {

	/** 
	 * 方法名 与  StudentMapper.xml 文件中的 sql语句的 id 相同
	 */
	
	/**
	 *  通过id查找考生 
	 */
	public List<Student> findStudent(Map<String, Object> param);
	
	/**
	 *  新增考生 
	 */
	public int addStudent(Student student);
	
	
}
