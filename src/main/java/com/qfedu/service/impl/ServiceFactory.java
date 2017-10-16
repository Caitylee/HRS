package com.qfedu.service.impl;

import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.Map;

import com.qfedu.service.DeptService;
import com.qfedu.service.EmpService;
import com.qfedu.service.UserService;

/**
 * ����ҵ�����Ĺ�����
 * @author ��
 *
 */
public final class ServiceFactory {
	private static Map<Class<?>, Object> map = new HashMap<>();
	
	static {
		map.put(UserService.class, ServiceProxy.creatProxy(new UserServiceImpl()));
		map.put(DeptService.class, ServiceProxy.creatProxy(new DeptServiceImpl()));
		map.put(EmpService.class, ServiceProxy.creatProxy(new EmpServiceImpl()));
	}

	private ServiceFactory() {
		throw new AssertionError();
	}
	
	/**
	 * ����ҵ�����Ĺ�������
	 * @param type ҵ����������
	 * @return ҵ�����
	 */
	public static <T> T create(Class<?> type) {
		return (T) map.get(type);
	}
}
