package com.bluemobi.pro.controller.api;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.bluemobi.cache.CacheService;
import com.bluemobi.constant.ErrorCode;
import com.bluemobi.location.Location;
import com.bluemobi.location.LocationUtils;
import com.bluemobi.pro.entity.AolUser;
import com.bluemobi.pro.entity.Complaint;
import com.bluemobi.pro.entity.FeedBack;
import com.bluemobi.pro.entity.Information;
import com.bluemobi.pro.entity.Novice;
import com.bluemobi.pro.entity.Question;
import com.bluemobi.pro.entity.RegisterUser;
import com.bluemobi.pro.entity.User;
import com.bluemobi.pro.service.impl.AccountsConfigService;
import com.bluemobi.pro.service.impl.AolUserService;
import com.bluemobi.pro.service.impl.ComplaintService;
import com.bluemobi.pro.service.impl.FeedBackService;
import com.bluemobi.pro.service.impl.InformationService;
import com.bluemobi.pro.service.impl.NoviceService;
import com.bluemobi.pro.service.impl.QuestionService;
import com.bluemobi.pro.service.impl.UserService;
import com.bluemobi.sys.page.Page;
import com.bluemobi.utils.CommonUtils;
import com.bluemobi.utils.ImageUtils;
import com.bluemobi.utils.ParamUtils;
import com.bluemobi.utils.Result;
import com.bluemobi.utils.SmsUtils;

@Controller
@RequestMapping("/app/common/")
public class CommonsApp {

	@Resource(name = "cacheTempCodeServiceImpl")
	private CacheService<String> cacheService;

	@Autowired
	private UserService service;

	@Autowired
	private FeedBackService fservice;

	@Autowired
	private AolUserService aolUserService;

	@Autowired
	private ComplaintService complaintService;
	
	@Autowired
	private QuestionService questionService;
	
	@Autowired
	private NoviceService noviceService;
	
	@Autowired
	private InformationService informationService;
	

	/**
	 * 发送验证码
	 * 
	 * @param params
	 * @return
	 */
	@RequestMapping(value = "sendCode", method = RequestMethod.POST)
	@ResponseBody
	public Result sendCode(@RequestParam Map<String, Object> params) {

		String code = null;
		try {
			if (ParamUtils.existEmpty(params, "mobile")) {
				return Result.failure();
			}

			// 验证手机号是否存在
			Map<String, Object> tempMap = new HashMap<String, Object>();
			tempMap.put("mobile", params.get("mobile"));
			// 生成验证码
			code = CommonUtils.getCode(6);

			String mobile = params.get("mobile").toString();
//			String result = JavaSmsApi.sendShortMessage(mobile, code);
			// 成功
			if (SmsUtils.cjsmsSend(code, mobile)) {
				cacheService.put(mobile, code);
				return Result.success();
			}
			// 失败
			else {
				return Result.failure(ErrorCode.ERROR_09);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return Result.failure();
		}
	}

	/**
	 * 老人端用户注册
	 * 
	 * @param user
	 * @return
	 */
	@RequestMapping(value = "register", method = RequestMethod.POST)
	@ResponseBody
	public Result register(RegisterUser user) {

		try {
			String requestCode = user.getCode();
			String code = cacheService.get(user.getMobile());
			if (service.isExist(user)) {
				return Result.failure(ErrorCode.ERROR_05);
			}
			 else if(StringUtils.isBlank(requestCode) || !requestCode.equals(code)) {
				 return Result.failure(ErrorCode.ERROR_10);
			 }
			else {
				service.addUser(user);
				return Result.success();
			}
		} catch (Exception e) {
			e.printStackTrace();
			return Result.failure();
		}
	}

	/**
	 * 老人端登录
	 * 
	 * @param user
	 * @return
	 */
	@RequestMapping(value = "login", method = RequestMethod.POST)
	@ResponseBody
	public Result checkLogin(User user) {

		User respUser = null;
		try {
			respUser = service.findUserByMobile(user);
			if (respUser == null || !respUser.getPassword().equals(user.getPassword())) {
				return Result.failure(ErrorCode.ERROR_03);
			}
			respUser.setPassword(null);
			return Result.success(respUser);
		} catch (Exception e) {
			e.printStackTrace();
			return Result.failure();
		}
	}

	@RequestMapping(value = "feedback", method = RequestMethod.POST)
	@ResponseBody
	public Result feedback(FeedBack feedBack,MultipartHttpServletRequest request) {

		try {
			
			List<String> pathList = new ArrayList<String>();
			Iterator<String> fileNames = request.getFileNames();
			while(fileNames.hasNext()) {
				String filename = fileNames.next();
				MultipartFile file = request.getFile(filename);
				String path = ImageUtils.saveImage(file, false)[0];
				pathList.add(path);
			}
			
			fservice.insert(feedBack,pathList);
		} catch (Exception e) {
			e.printStackTrace();
			return Result.failure();
		}
		return Result.success();
	}

	@RequestMapping(value = "record", method = RequestMethod.POST)
	@ResponseBody
	public Result record(@RequestParam Map<String, Object> params) {

		if (ParamUtils.existEmpty(params, "userId"))
			return Result.failure(ErrorCode.ERROR_02);

		String aolUserId = params.get("userId").toString();
		Double lon = params.get("lon") == null ? null : Double.parseDouble(params.get("lon").toString());
		Double lat = params.get("lat") == null ? null : Double.parseDouble(params.get("lat").toString());
		String address = params.get("address") == null ? "" : params.get("address").toString();
		Location location = new Location(aolUserId, lon, lat,address);

		LocationUtils.create().receivceLocation(location);
		return Result.success();
	}

	@RequestMapping(value = "uploadHead", method = RequestMethod.POST)
	@ResponseBody
	public Result uploadHead(User user, @RequestParam("head") MultipartFile file) {

		String headPic = null;
		try {
			headPic = ImageUtils.saveImage(file, false)[0];
			user.setHeadPic(headPic);
			service.modifyUser(user);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return Result.success();
	}

	// 实时获取用户坐标
	@RequestMapping(value = "coordinates", method = RequestMethod.POST)
	@ResponseBody
	public Result getCoordinates(@RequestParam Map<String, Object> params) {

		if (ParamUtils.existEmpty(params, "aolUserId"))
			return Result.failure(ErrorCode.ERROR_02);

		String aolUserId = params.get("aolUserId").toString();
		Location location = LocationUtils.create().getLocation(aolUserId);
		if (location == null)
			return Result.failure(ErrorCode.ERROR_14);
		// 用户已下线

		// -------------------
		// 测试
		// -------------------
		// Location location = LocationUtils.create().getTest(aolUserId);
		return Result.success(location);
	}

	// 查询关注人列表
	@RequestMapping(value = "foucsList", method = RequestMethod.POST)
	@ResponseBody
	public Result findFoucsList(@RequestParam Map<String, Object> params) {
		List<AolUser> aolUserList = null;
		try {
			aolUserList = aolUserService.findFocus(params.get("memberId").toString());
		} catch (Exception e) {
			e.printStackTrace();
			return Result.failure();
		}
		return Result.success(aolUserList);
	}
	
	/**
	 * 投诉
	 * @return
	 */
	@RequestMapping(value = "complaint", method = RequestMethod.POST)
	@ResponseBody
	public Result complaint(Complaint complaint) {
		try {
			complaintService.insert(complaint);
		} catch (Exception e) {
			e.printStackTrace();
			return Result.failure();
		}
		return Result.success();
	}
	

	@RequestMapping(value = "questionList",method = RequestMethod.POST)
	@ResponseBody
	public Result questionList() {
		List<Question> list = null;
		try {
			list = questionService.findAll();
		} catch (Exception e) {
			e.printStackTrace();
			return Result.failure();
		}
		return Result.success(list);
	}
	
	@RequestMapping(value = "novice", method = RequestMethod.POST)
	@ResponseBody
	public Result noviceList() {
		List<Novice> list = null;
		try {
			list = noviceService.findAll();
		} catch (Exception e) {
			e.printStackTrace();
			return Result.failure();
		}
		return Result.success(list);
	}
	
	
	@RequestMapping(value = "info/list", method = RequestMethod.POST)
	@ResponseBody
	public Result infoList(Integer pageNum,Integer pageSize) {
		
		Integer currentPage = pageNum == null ? 1 : pageNum;
		pageSize = pageSize == null ? 10 : pageSize;

		Page<Information> page = null;
		try {
			Map<String,Object> params = new HashMap<String,Object>();
			page = informationService.page(params, currentPage, pageSize);
		} catch (Exception e) {
			e.printStackTrace();
			return Result.failure();
		}
		return Result.success(page);
	}
	
	@RequestMapping(value = "info/detail", method = RequestMethod.POST)
	@ResponseBody
	public Result infoDetail(Integer id) {
		
		Information info = null;
		try {
			info = informationService.detail(id);
		} catch (Exception e) {
			e.printStackTrace();
			return Result.failure();
		}
		return Result.success(info);
	}
}
