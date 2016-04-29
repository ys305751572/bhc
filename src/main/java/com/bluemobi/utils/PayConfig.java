package com.bluemobi.utils;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bluemobi.pay.excute.PayRequest;

public class PayConfig {

	public final static String NOTIFY_URL_WEIXIN = "";
	public final static String NOTIFY_URL_ALIPAY = "";
	/**
	 * 
	 * @param request
	 * @param response
	 * @param sn 订单号
	 * @param totalFee 支付价格
	 * @param payWay 支付方式 WEIXIN,ALIPAY
	 * @return
	 */
	public static Map<String,Object> config(HttpServletRequest request,HttpServletResponse response,String sn,Double totalFee,String payWay) {
		Map<String,Object> params = new HashMap<String,Object>();
		int totelFee = 1;
		if("ALIPAY".equals(payWay)) {
			// 支付宝
			params.put("sn", sn);
			params.put("totelFee", totelFee);
			params.put("itemName", "支付");
			params.put("itemDesc", "支付");
			params.put("tag", "3");
			params.put("url", NOTIFY_URL_ALIPAY);
		}
		else {
			// 微信
			String prepayid = null; //预支付款ID
			request.setAttribute("fee",totelFee);
			request.setAttribute("sn",sn);
			request.setAttribute("prepayid",prepayid);
			params = PayRequest.pay(request,response,NOTIFY_URL_WEIXIN);
		}
		return params;
	}
}
