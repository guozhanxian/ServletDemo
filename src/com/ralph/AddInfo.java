package com.ralph;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

/**
 * Created by guozhanxian on 2017/8/9.
 */
public class AddInfo extends HttpServlet
{
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        request.setCharacterEncoding("utf-8");
        String str = request.getQueryString();
        String name = request.getParameter("studName");
        String pwd = request.getParameter("password");
        String sex = request.getParameter("sex");
        String[] likes = request.getParameterValues("likes");
        String intro = request.getParameter("intro");

        System.out.println("已经把数据保存到数据库！");

        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        out.println("<html><head><meata charset=\"utf-8\"></head><body><h1>注册成功：</h1><table>");
        out.println("<tr><td>姓名：</td><td>"+name+"</td></tr>");
        out.println("<tr><td>密码：</td><td>"+pwd+"</td></tr>");
        out.println("<tr><td>性别：</td><td>"+sex+"</td></tr>");
        out.println("<tr><td>爱好：</td><td>"+ Arrays.toString(likes)+"</td></tr>");
        out.println("<tr><td>简介：</td><td>"+intro+"</td></tr>");
        out.println("</table></body></html>");
        out.flush();
        out.close();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        doPost(req,resp);
    }
}
