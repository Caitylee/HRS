package com.qfedu.controller;

import com.qfedu.domain.Dept;
import com.qfedu.domain.Emp;
import com.qfedu.util.CommonUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.File;
import java.io.IOException;
import java.util.Date;

@WebServlet(urlPatterns = "/editEmp",loadOnStartup = 1)
@MultipartConfig
public class EditEmpServlet extends BaseServlet{
    private static final int DEFAULT_IMAGE_WIDTH = 200;
    private static final int DEFAULT_IMAGE_HEIGHT = 150;
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String method=req.getParameter("fun");

        if (method.equals("edit")){
            String noString = req.getParameter("no");
            int no = Integer.parseInt(noString);
            Emp emp=getEmpService().findEmpByNo(no);
            req.setAttribute("emp",emp);
            req.getRequestDispatcher("editEmp.jsp").forward(req,resp);
        }
        else if (method.equals("update")){
            int no = Integer.parseInt(req.getParameter("no"));
            String name = req.getParameter("name");
            boolean sex = req.getParameter("sex").equals("1");
            String job = req.getParameter("job");
            double salary = Double.parseDouble(req.getParameter("salary"));
            String hireDateStr = req.getParameter("hiredate");
            Date hireDate = CommonUtil.stringToDate("yyyy-MM-dd", hireDateStr);
            String tel = req.getParameter("tel");
            Emp emp = new Emp();
            emp.setNo(no);
            emp.setName(name);
            emp.setJob(job);
            emp.setSex(sex);
            emp.setSalary(salary);
            emp.setStatus(true);
            emp.setHireDate(hireDate);
            emp.setTel(tel);
            Emp mgr = new Emp();
            emp.setMgr(mgr);
            Part part = req.getPart("photo");
            if (part.getSize() > 0) {
                String newFilename = CommonUtil.getUniqueFilename() + ".png";
                String path = req.getServletContext().getRealPath("/images");
                File file = new File(path + "/" + newFilename);
                CommonUtil.compressImage(part.getInputStream(), file,
                        DEFAULT_IMAGE_WIDTH, DEFAULT_IMAGE_HEIGHT);
                emp.setPhoto(newFilename);
            }
            int deptNo = Integer.parseInt(req.getParameter("dno"));
            Dept dept = new Dept();
            dept.setNo(deptNo);
            emp.setDept(dept);
            getEmpService().updataEmp(emp);
            resp.sendRedirect("emp.jsp");
        }


    }
}
