package com.bluemobi.pro.controller.api;

import java.util.Collection;
import java.util.Map;

import org.apache.catalina.ha.backend.CollectedInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bluemobi.constant.Constant;
import com.bluemobi.pro.entity.Pathology;
import com.bluemobi.pro.service.impl.PathologyService;
import com.bluemobi.sys.page.Page;
import com.bluemobi.utils.Result;

/**
 * 病理controller
 * @author Administrator
 *
 */
@Controller
@RequestMapping("/app/pathology/")
public class PathologyApp {

	@Autowired
	private PathologyService service;
	
	/**
	 * 病理列表
	 * @param params
	 * @return
	 */
	@RequestMapping(value = "page", method = RequestMethod.POST)
	@ResponseBody
	public Result page(@RequestParam Map<String,Object> params) {
		
		Integer currentPage = params.get("pageNum") == null ? 1 : Integer.parseInt(params.get("pageNum").toString());
		Integer pageSize = params.get("pageSize") == null ? 10 : Integer.parseInt(params.get("pageSize").toString());
		
		Page<Pathology> page = null;
		try {
			params.put("type", "0"); // 设置类型为病理
			page = service.page(params, currentPage, pageSize);
			
			Collection<Pathology> list = page.getRows();
			for (Pathology pathology : list) {
				pathology.setImage(Constant.DOMAIN_IMAGE + pathology.getImage());
			}
		} catch (Exception e) {
			e.printStackTrace();
			return Result.failure();
		}
		return Result.success(page);
	}
	
	/**
	 * 查询病理详细信息
	 * @param pathology
	 * @return
	 */
	@RequestMapping(value = "detail", method = RequestMethod.POST)
	@ResponseBody
	public Result detail(final Pathology pathology) {
		
		Pathology pathology2 = null;
		try {
			pathology2 = service.findById(pathology);
			pathology2.setImage(Constant.DOMAIN_IMAGE + pathology2.getImage());
		} catch (Exception e) {
			e.printStackTrace();
			return Result.failure();
		}
		return Result.success(pathology2);
	}
}
