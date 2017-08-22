package com.ralph.web;

import com.ralph.service.CountManager;
import com.ralph.service.CountManagerImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.Locale;
import java.util.ResourceBundle;

/**
 * Created by guozhanxian.
 *
 * @author 果占先
 *         日期：2017-08-21
 * @version 1.0
 */
@WebServlet("/change.action")
public class Change extends HttpServlet
{
    private CountManager countManager = new CountManagerImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        request.setCharacterEncoding("utf-8");
        String id1 = request.getParameter("id1");
        String id2 = request.getParameter("id2");
        String money = request.getParameter("money");

        String str = countManager.change(Integer.parseInt(id1),Integer.parseInt(id2),Double.parseDouble(money));

        Locale l = request.getLocale();
        ResourceBundle rb = ResourceBundle.getBundle("com.ralph.res.message",l);
        String msg = rb.getString(str);

        response.sendRedirect("change.jsp?msg="+ URLEncoder.encode(msg,"utf-8")+"&code="+str);
    }

}
