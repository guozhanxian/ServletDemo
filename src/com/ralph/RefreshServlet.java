package com.ralph;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by guozhanxian on 2017/8/11.
 */
public class RefreshServlet extends HttpServlet
{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        resp.setContentType("text/html;charset=utf-8");
        resp.addHeader("Refresh","5;url=aaa.html");

        PrintWriter out = resp.getWriter();
        out.println("<html><head><meta charset=\"utf-8\"></head><body><h1>5秒后自动跳转回主页</h1></body></html>");
        out.flush();
        out.close();
    }
}
