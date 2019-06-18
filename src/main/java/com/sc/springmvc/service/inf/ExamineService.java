package com.sc.springmvc.service.inf;

import java.util.List;
import java.util.Map;

import com.sc.springmvc.pojo.Examine;

public interface ExamineService {

	public int addExamine(Examine examine);
	
	public List<Examine> findExamine(Map<String, Object> param);
	
}
