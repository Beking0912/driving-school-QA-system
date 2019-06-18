package com.sc.springmvc.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.sc.springmvc.dao.UserDao;
import com.sc.springmvc.pojo.User;
import com.sc.springmvc.service.inf.UserService;

@Service("userService")
public class UserServiceImpl implements UserService {

	@Resource
	private UserDao userDao;
	
	@Override
	public User findUserById(Integer id) {
		// TODO Auto-generated method stub
		return this.userDao.findUserById(id);
	}
	
	/**
	 *  通过用户名和密码查找用户 
	 */
	public List<User> findUser(Map<String, Object> param) {
		List<User> user = userDao.findUser(param);
		return user;
	}
    
    //新增用户
    public int addUser(User user) {
    	return this.userDao.addUser(user);
    }

}
