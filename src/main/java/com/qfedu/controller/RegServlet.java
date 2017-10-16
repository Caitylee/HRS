package com.qfedu.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.qfedu.domain.User;

@WebServlet(urlPatterns = "/reg", loadOnStartup = 1)
public class RegServlet extends BaseServlet {
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		String email = req.getParameter("email");
		if (username != null && password != null && email != null) {
			User user = new User();
			user.setUsername(username);
			user.setPassword(password);
			user.setEmail(email);
			if (getUserService().register(user)) {
				resp.sendRedirect("login.jsp");
			} else {
				req.setAttribute("hint", "ע��ʧ��! �볢�Ը����û���!");
				req.getRequestDispatcher("register.jsp").forward(req, resp);
			}
		} else {
			req.setAttribute("hint", "��������Ч��ע����Ϣ!");
			req.getRequestDispatcher("register.jsp").forward(req, resp);
		}
	}

}
