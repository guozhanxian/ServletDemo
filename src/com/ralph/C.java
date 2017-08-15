package com.ralph;

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
@WebServlet("/CCC.action")
public class C extends HttpServlet
{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        req.setCharacterEncoding("utf-8");
        String str = req.getQueryString();
        String id = req.getParameter("id");
        String name = req.getParameter("name");
        String age = req.getParameter("age");
        System.out.println("CCC Servlet:"+id+"<<<"+name+"<<<<"+age);

        resp.sendRedirect("aaa.html");
    }
}
