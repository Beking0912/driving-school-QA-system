package com.sc.springmvc.service.inf;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.sc.springmvc.pojo.User;

public interface UserService {

	public User findUserById(Integer id);
	
	/**
	 *  通过用户名和密码查找用户 
	 */
	public List<User> findUser(Map<String, Object> param);
    
	//新增用户
    public int addUser(User user);
	
}
