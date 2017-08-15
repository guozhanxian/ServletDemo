package com.ralph;

import com.ralph.domain.Student;

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
@WebServlet("/AAA.action")
public class A extends HttpServlet
{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        Student s = new Student(12,"张三李四",22);
        req.setAttribute("msg","Hello World");
        req.setAttribute("s",s);
        req.getRequestDispatcher("BBB.action").forward(req,resp);
    }
}
