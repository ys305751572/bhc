package com.bluemobi.utils;

import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public class SmsUtils
{
  public static boolean cjsmsSend(String code, String[] mobiles)
  {
    String content = "【健康管家】您的验证码为:" + code + ",请不要将验证码透露给其他人";

    String url = "http://116.255.153.152:9999/sms.aspx";
    String account = "whgjkj";
    String password = "baicai626";
    String action = "send";
    String sendTime = DateUtils.getCurrentTime();

    StringBuffer buffer = new StringBuffer();
    try {
      buffer.append("http://116.255.153.152:9999/sms.aspx")
        .append("?")
        .append("action=")
        .append(URLEncoder.encode("send", "utf-8"))
        .append("&")
        .append("userid=529")
        .append("&")
        .append("account=")
        .append(URLEncoder.encode("whgjkj", "utf-8"))
        .append("&")
        .append("password=")
        .append(URLEncoder.encode("baicai626", "utf-8"))
        .append("&")
        .append("mobile=")
        .append(URLEncoder.encode(linkMobile(mobiles), "utf-8"))
        .append("&")
        .append("content=")
        .append(URLEncoder.encode(content, "utf-8"))
        .append("&")
        .append("sendTime=")
        .append(URLEncoder.encode(sendTime, "utf-8"))
        .append("&")
        .append("extno=");
    } catch (UnsupportedEncodingException e) {
      e.printStackTrace();
    }

    String result = WebserviceUtil.post(buffer.toString());
    System.out.println(result);
    return result.contains("Success");
  }

  private static String linkMobile(String[] mobiles) {
    if ((mobiles == null) || (mobiles.length == 0)) return "";
    StringBuffer buffer = new StringBuffer();
    String[] arrayOfString = mobiles; int j = mobiles.length; for (int i = 0; i < j; i++) { String mobile = arrayOfString[i];
      buffer.append(mobile).append(",");
    }
    return buffer.toString().substring(0, buffer.toString().length() - 1);
  }

  public static void main(String[] args) {
    String mobile = "13476107753";
    cjsmsSend(CommonUtils.getCode(6), new String[] { mobile });
  }
}