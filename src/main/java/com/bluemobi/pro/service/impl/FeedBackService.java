package com.bluemobi.pro.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bluemobi.pro.entity.FeedBack;
import com.bluemobi.pro.entity.Image;
import com.bluemobi.sys.service.BaseService;
import com.bluemobi.utils.UUIDUtil;

@Service
public class FeedBackService extends BaseService{

	private static final String PRIFIX = FeedBackService.class.getName();
	
	@Autowired
	private ImageService imageService;
	
	/**
	 * 新增一键反馈
	 * @param feedBack
	 * @throws Exception
	 */
	@Transactional
	public void insert(FeedBack feedBack,List<String> pathList) throws Exception {
		
		feedBack.setId(UUIDUtil.generateUUID());
		feedBack.setCreateDate(System.currentTimeMillis());
		this.getBaseDao().save(PRIFIX + ".insert", feedBack);
		
		Image image = null;
		if(!pathList.isEmpty()) {
			for (String path : pathList) {
				image = new Image();
				image.setPath(path);
				image.setFeekbackId(feedBack.getId());
				
				imageService.insert(image);
			}
		}
	}
}
