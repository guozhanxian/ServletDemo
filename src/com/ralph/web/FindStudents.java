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
import java.util.List;

/**
 * Created by guozhanxian.
 *
 * @author 果占先
 *         日期：2017-08-14
 * @version 1.0
 */
@WebServlet("/findStudents.action")
public class FindStudents extends HttpServlet
{
    private SchoolBaseInfoManager schoolBaseInfoManager = new SchoolBaseInfoManagerImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        List<Student> list = schoolBaseInfoManager.findAllStudents();
        req.setAttribute("list",list);
        req.getRequestDispatcher("viewStudents.jsp").forward(req,resp);
    }
}
