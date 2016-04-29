package com.bluemobi.pro.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.bluemobi.pro.entity.Question;
import com.bluemobi.sys.service.BaseService;

@Service
public class QuestionService extends BaseService{

	public static final String PRIFIX = Question.class.getName();
	
	public List<Question> findAll() throws Exception {
		return this.getBaseDao().getList(PRIFIX + ".findAll");
	}
}
