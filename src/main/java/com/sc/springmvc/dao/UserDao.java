package com.sc.springmvc.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.sc.springmvc.pojo.User;

public interface UserDao {

	/** 
	 * 方法名 与  UserMapper.xml 文件中的 sql语句的 id 相同
	 */
    public User findUserById(Integer id);
    
	/**
	 *  通过用户名和密码查找用户 
	 */
    public List<User> findUser(Map<String, Object> param);
    
    //新增用户
    public int addUser(User user);
	
}
