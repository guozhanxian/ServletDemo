package com.ralph.web;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by guozhanxian.
 *
 * @author 果占先
 *         日期：2017-08-15
 * @version 1.0
 */
@WebServlet("/clientCount2.action")
public class ClientCount2 extends HttpServlet
{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        HttpSession session = req.getSession();
        Integer value = (Integer) session.getAttribute("ralph");
        if(value==null)
            value = 0;
        value++;

        session.setAttribute("ralph",value);

        req.setAttribute("count",value);
        req.getRequestDispatcher("clientCount.jsp").forward(req,resp);
    }
}
