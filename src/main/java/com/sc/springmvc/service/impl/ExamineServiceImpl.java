package com.sc.springmvc.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sc.springmvc.dao.ExamineDao;
import com.sc.springmvc.pojo.Examine;
import com.sc.springmvc.service.inf.ExamineService;

@Service("examineService")
public class ExamineServiceImpl implements ExamineService{

	@Autowired
	private ExamineDao examineDao;
	
	public int addExamine(Examine examine) {
		return this.examineDao.addExamine(examine);
	}
	
	public List<Examine> findExamine(Map<String, Object> param) {
		return this.examineDao.findExamine(param);
	}
	
}
