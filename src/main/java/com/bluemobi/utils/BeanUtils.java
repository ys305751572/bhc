package com.bluemobi.utils;

import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.bluemobi.pro.entity.User;

public class BeanUtils {

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static List listToMap(List list) {
		List _list = new ArrayList();
		for (Object object : list) {
			_list.add(beanToMap(object));
		}
		return _list;
	}
	
	public static Map<String,Object> beanToMap(Object data) {
		Assert.IsNotNull(data);
		Map<String,Object> map = new HashMap<String,Object>();
		Field[] fields = data.getClass().getDeclaredFields();
		try {
			
			PropertyDescriptor pd = null;
			for (Field field : fields) {
				String k = field.getName();
				Object v = null;
				pd = new PropertyDescriptor(k, data.getClass());
				Method getMethod = pd.getReadMethod();
				if(pd != null) {
					v = getMethod.invoke(data);
				}
				if(v != null) {
					map.put(k, v);
				}
			}
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (IntrospectionException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		return map;
	}
	
	public static void main(String[] args) {
		User user = new User();
		user.setUserId("123456");
		user.setName("admin");
		user.setBak1(null);
		
		Map<String,Object> map = beanToMap(user);
		for (Map.Entry<String, Object> obj : map.entrySet()) {
			System.out.println("key:" + obj.getKey() + ":value :" + obj.getValue());
		}
	}
}

