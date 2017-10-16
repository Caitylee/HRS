package com.qfedu.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/login", loadOnStartup = 1)
public class LoginServlet extends BaseServlet {
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		if (username != null && password != null) {
			if (getUserService().login(username, password)) {
				req.getSession().setAttribute("username", username);
				resp.sendRedirect("dept");
			} else {
				req.setAttribute("hint", "�û������������!");
				req.getRequestDispatcher("login.jsp").forward(req, resp);
			}
		} else {
			req.setAttribute("hint", "��������Ч�ĵ�¼��Ϣ!");
			req.getRequestDispatcher("login.jsp").forward(req, resp);
		}
	}

}
