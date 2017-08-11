package com.ralph;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

/**
 * Created by guozhanxian on 2017/8/11.
 */
public class ShowHeader extends HttpServlet
{
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        String method = req.getMethod();
        String uri = req.getRequestURI();
        String protocol = req.getProtocol();
        String queryString = req.getQueryString();

        Enumeration<String> keys = req.getHeaderNames();

        resp.setContentType("text/html;charset=utf-8");
        PrintWriter out = resp.getWriter();
        out.println("<html><head><meta charset=\"utf-8\"></head><body><table>");
        out.println("<tr colspan=\"2\"><td>"+method+" "+uri+(queryString==null?"":queryString)+" "+protocol+"</td></tr>");

        while(keys.hasMoreElements())
        {
            String key = keys.nextElement();
            String value = req.getHeader(key);
            out.println("<tr><td>"+key+"</td><td>"+value+"</td></tr>");
        }

        out.println("</table></body></html>");
        out.flush();
        out.close();
    }
}
