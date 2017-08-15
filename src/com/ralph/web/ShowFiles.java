package com.ralph.web;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;

/**
 * Created by guozhanxian.
 *
 * @author 果占先
 *         日期：2017-08-15
 * @version 1.0
 */
public class ShowFiles extends HttpServlet
{
    private String path;
    @Override
    public void init() throws ServletException
    {
        ServletConfig config = getServletConfig();
        path = config.getInitParameter("filedir");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        File file = new File(path);
        File[] fs = file.listFiles();

        req.setAttribute("fs",fs);
        req.getRequestDispatcher("showFile.jsp").forward(req,resp);
    }
}
