package com.ralph.web;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by guozhanxian.
 *
 * @author 果占先
 *         日期：2017-08-15
 * @version 1.0
 */
@WebServlet("/clientCount.action")
public class ClientCount extends HttpServlet
{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        Cookie[] cs = req.getCookies();
        Cookie obj = null;

        if(cs!=null && cs.length>0)
        {
            for(Cookie c:cs)
            {
                if("ralph".equals(c.getName()))
                {
                    obj = c;
                    break;
                }
            }
        }

        int visit = 0;
        if(obj != null)
        {
            visit = Integer.parseInt(obj.getValue());
        }

        visit++;

        Cookie c = new Cookie("ralph",visit+"");
        c.setMaxAge(60*60*24*7);
        resp.addCookie(c);

        req.setAttribute("count",visit);
        req.getRequestDispatcher("clientCount.jsp").forward(req,resp);
    }
}
