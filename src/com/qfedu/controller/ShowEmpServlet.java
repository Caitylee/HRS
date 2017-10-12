package com.qfedu.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.alibaba.fastjson.JSON;
import com.qfedu.domain.Dept;
import com.qfedu.dto.EmpDto;
import com.qfedu.util.PageBean;

@WebServlet(urlPatterns = "/emp", loadOnStartup = 1)
public class ShowEmpServlet extends BaseServlet {
	private static final int DEFAULT_PAGE = 1;
	private static final int DEFAULT_SIZE = 5;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Dept dept = (Dept) req.getSession().getAttribute("dept");

		if (dept != null) {
			int page = DEFAULT_PAGE;
			String pageStr = req.getParameter("page");
			if (pageStr != null) {
				try {
					page = Integer.parseInt(pageStr);
					page = page <= 0 ? DEFAULT_PAGE : page;
				} catch (NumberFormatException e) {
				}
			}
			int size = DEFAULT_SIZE;
			PageBean<EmpDto> pageBean = getEmpService().listAllEmpsByDeptNo(dept, page, size);
			/*req.setAttribute("empList", pageBean.getDataModel());
		    req.setAttribute("totalPage", pageBean.getTotalPage());
		    req.setAttribute("currentPage", pageBean.getCurrentPage());
			req.getRequestDispatcher("emp.jsp").forward(req, resp);*/
			String jsonStr = JSON.toJSONString(pageBean);
			// 2. ��JSON�ַ�������������ͨ��MIME���͸��������������JSON��ʽ
			resp.setContentType("application/json;charset=utf-8");
			PrintWriter pw = resp.getWriter();
			pw.write(jsonStr);
			pw.close();
		}
	}
}
