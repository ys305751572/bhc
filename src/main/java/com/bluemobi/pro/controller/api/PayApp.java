package com.bluemobi.pro.controller.api;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.bluemobi.pay.util.XMLUtil;
import com.bluemobi.pro.service.impl.SigningService;

@RequestMapping(value = "/app/pay")
@Controller
public class PayApp {

	

	@Autowired
	private SigningService service;

	@RequestMapping(value = "/alipayNotify")
	public void alipayNotify(HttpServletRequest request) {
		String status = request.getParameter("trade_status").toString();

		if ("TRADE_SUCCESS".equals(status) || "FINISH".equals(status)) {
			System.out.println("SUCCESS");
			String sn = request.getParameter("out_trade_no").toString();
			double amount = Double.parseDouble(request.getParameter("total_fee").toString());

			try {
				service.payComplate(sn);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	@RequestMapping(value = "/weixiNotify")
	public void weixiNotify(HttpServletRequest request) {
		Map<String, Object> result = parse(request);
		String status = result.get("result_code").toString();
		if ("SUCCESS".equals(status)) {
			System.out.println("SUCCESS");

			String sn = result.get("out_trade_no").toString();
			double amount = Double.parseDouble(request.getParameter("total_fee").toString());

			try {
				service.payComplate(sn);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> parse(HttpServletRequest request) {
		Map<String, Object> resultMap = null;
		try {
			BufferedReader reader = new BufferedReader(new InputStreamReader(request.getInputStream()));
			String line = null;
			String result = "";
			while ((line = reader.readLine()) != null) {
				result += line;
			}
			System.out.println("result:" + result);
			resultMap = XMLUtil.doXMLParse(result);
		} catch (IOException e1) {
			e1.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return resultMap;
	}
}
