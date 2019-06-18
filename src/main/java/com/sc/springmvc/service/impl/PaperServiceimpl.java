package com.sc.springmvc.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sc.springmvc.dao.PaperDao;
import com.sc.springmvc.pojo.Paper;
import com.sc.springmvc.service.inf.PaperService;

@Service("paperService")
public class PaperServiceimpl implements PaperService {
	
	@Autowired
	private PaperDao paperDao;
	
	public int addPaper(Paper paper) {
		return this.paperDao.addPaper(paper);
	}

	public List<Paper> findPaper(Map<String, Object> param) {
		return this.paperDao.findPaper(param);
	}
	
}
