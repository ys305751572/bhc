package com.bluemobi.pro.service.impl;

import org.springframework.stereotype.Service;

import com.bluemobi.pro.entity.Image;
import com.bluemobi.sys.service.BaseService;

@Service
public class ImageService extends BaseService{

	public static final String PRIFIX = Image.class.getName();
	
	public void insert(Image image) throws Exception {
		this.getBaseDao().save(PRIFIX + ".insert", image);
	}
}
