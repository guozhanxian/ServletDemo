package com.ralph.web;

import com.ralph.domain.Student;
import com.ralph.service.SchoolBaseInfoManager;
import com.ralph.service.SchoolBaseInfoManagerImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by guozhanxian.
 *
 * @author 果占先
 *         日期：2017-08-14
 * @version 1.0
 */
@WebServlet("/registStudent.action")
public class RegistStudent extends HttpServlet
{
    private SchoolBaseInfoManager schoolBaseInfoManager = new SchoolBaseInfoManagerImpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        req.setCharacterEncoding("utf-8");
        String name = req.getParameter("name");
        String age = req.getParameter("age");

        Student s = new Student();
        s.setName(name);
        s.setAge(Integer.parseInt(age));

        try{
            schoolBaseInfoManager.addStudentInfo(s);
            //req.getRequestDispatcher("ok.html").forward(req,resp);
            resp.sendRedirect("findStudents.action");
        }catch(Exception e)
        {
            //保存失败

        }
    }
}
