package com.qfedu.controller;

import com.qfedu.domain.Dept;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;


@WebServlet(urlPatterns = "/editDept", loadOnStartup = 1)
public class EditDeptServlet extends BaseServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String method= req.getParameter("method");
        if (method.equals("edit")){
            String  noString=req.getParameter("no");
            int no=Integer.parseInt(noString);
            Dept dept=getDeptService().findById(no);
            req.setAttribute("dept",dept);
            req.getRequestDispatcher("edit_dept.jsp").forward(req,resp);
        }else  if (method.equals("update")){
            String  noString=req.getParameter("no");
            int no=Integer.parseInt(noString);
            String name=req.getParameter("name");
            String loc=req.getParameter("location");
            Dept dept=new Dept();

            dept.setNo(no);
            dept.setName(name);
            dept.setLocation(loc);
            if (getDeptService().updateDept(dept)!=null){
                // 如果更新部门成功则先刷新缓存数据再重定向到查看部门页面
                Map<Integer, Dept> map = (Map<Integer, Dept>)
                        req.getServletContext().getAttribute("cache");
                map.put(dept.getNo(), dept);

            }
            resp.sendRedirect("dept");



        }



    }
}
