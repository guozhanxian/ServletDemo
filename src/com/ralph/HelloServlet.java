package com.ralph;

import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by guozhanxian on 2017/8/9.
 */
public class HelloServlet extends javax.servlet.http.HttpServlet
{
    private int i = 1;
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException
    {
        doGet(request,response);
    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException
    {
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        out.println("<html><head><meata charset=\"utf-8\"></head><body><h1>Hello World"+(i++)+hashCode()+"</h1></body></html>");
        out.flush();
        out.close();
    }
}
