package com.ralph;

import com.ralph.domain.Student;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;

/**
 * Created by guozhanxian.
 *
 * @author 果占先
 *         日期：2017-08-14
 * @version 1.0
 */
@WebServlet("/BBB.action")
public class B extends HttpServlet
{

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        String str = (String) request.getAttribute("msg");
        Student s = (Student) request.getAttribute("s");

        System.out.println(str);
        System.out.println(s);

        response.sendRedirect("CCC.action?id="+s.getId()+"&name="+ URLEncoder.encode(s.getName(),"utf-8")+"&age="+s.getAge());
    }
}
