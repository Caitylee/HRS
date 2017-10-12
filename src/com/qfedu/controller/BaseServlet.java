package com.qfedu.controller;

import javax.servlet.http.HttpServlet;

import com.qfedu.service.DeptService;
import com.qfedu.service.EmpService;
import com.qfedu.service.UserService;
import com.qfedu.service.impl.ServiceFactory;

/**
 * �����Զ���Servlet�ĸ���
 * @author ���
 *
 */
public abstract class BaseServlet extends HttpServlet {

	/**
	 * ��ȡ�û�ҵ�����
	 */
	protected UserService getUserService() {
		return ServiceFactory.create(UserService.class);
	}
	
	/**
	 * ��ȡ����ҵ�����
	 */
	protected DeptService getDeptService() {
		return ServiceFactory.create(DeptService.class);
	}
	
	/**
	 * ��ȡԱ��ҵ����� 
	 */
	protected EmpService getEmpService() {
		return ServiceFactory.create(EmpService.class);
	}
}
