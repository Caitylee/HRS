package com.qfedu.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "/delEmp",loadOnStartup = 1)
public class DelEmpServlet extends BaseServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String noString = req.getParameter("no");
        int no= Integer.parseInt(noString);
        boolean boo=getEmpService().removeEmpByNo(no);
        String responseText=boo?"success":"failed";
        PrintWriter printWriter=resp.getWriter();
        printWriter.write(responseText);
        printWriter.close();



    }
}
