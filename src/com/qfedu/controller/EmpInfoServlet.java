package com.qfedu.controller;

import com.qfedu.domain.Emp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/empinfo",loadOnStartup = 1)
public class EmpInfoServlet extends BaseServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // super.service(req, resp);
        String noString = req.getParameter("no");
        int no=Integer.parseInt(noString);
        Emp emp=getEmpService().findEmpByNo(no);
        req.setAttribute("emp",emp);
        req.getRequestDispatcher("/empinfo.jsp").forward(req,resp);




    }
}
