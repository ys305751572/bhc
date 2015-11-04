package com.bluemobi.utils;

/**
 * 短信发送工具类
 * @author yesong 
 *
 */
public class SmsUtils {

	public static String cjsmsSend(String content,String... mobiles) {
		final String url = "http://116.255.153.152:9999/sms.aspx";
		final String account = "whgjkj";
		final String password = "baicai626";
		final String action = "send";
		final String sendTime = DateUtils.getCurrentTime();
		
		StringBuffer buffer = new StringBuffer();
		buffer.append(url)
		.append("?")
		.append("action=")
		.append(action)
		.append("&")
		.append("userid=529")
		.append("&")
		.append("account=")
		.append(account)
		.append("&")
		.append("password=")
		.append(password)
		.append("&")
		.append("mobile=")
		.append(linkMobile(mobiles))
		.append("&")
		.append("content=")
		.append(content)
		.append("&")
		.append("sendTime=")
		.append(sendTime)
		.append("&")
		.append("extno=");
		
		System.out.println("url:" + buffer.toString());
		String result = WebserviceUtil.post(buffer.toString());
		System.out.println(result);
		return null;
	}
	
	private static String linkMobile(String... mobiles) {
		if(mobiles == null || mobiles.length == 0) return "";
		StringBuffer buffer = new StringBuffer();
		for (String mobile : mobiles) {
			buffer.append(mobile).append(",");
		}
		return buffer.toString().substring(0, buffer.toString().length() - 1);
	}
	
	public static void main(String[] args) {
		String mobile = "13476107753";
		String content = "这是web短信测试";
		
		cjsmsSend(content, mobile);
	}
}
