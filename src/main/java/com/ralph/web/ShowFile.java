package com.ralph.web;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

/**
 * Created by guozhanxian.
 *
 * @author 果占先
 *         日期：2017-08-15
 * @version 1.0
 */
@WebServlet("/showFile.action")
public class ShowFile extends HttpServlet
{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        req.setCharacterEncoding("utf-8");
        String type = req.getParameter("type");
        String dir = req.getParameter("dir");

        if("1".equals(type))
        {
            //Dir
            File file = new File(dir);
            File[] fs = file.listFiles();
            req.setAttribute("fs",fs);
            req.getRequestDispatcher("showFile.jsp").forward(req,resp);
        }else if("2".equals(type)){
            //File
            File file = new File(dir);
            InputStream is = new FileInputStream(file);

            resp.setContentType("bin");
            resp.addHeader("Content-Disposition","attachment;filename=\""+file.getName()+"\"");
            OutputStream os = resp.getOutputStream();
            byte[] res = new byte[1024*2];
            int length = 0;
            while((length=is.read(res))>0)
            {
                os.write(res,0,length);
            }
            os.flush();
            os.close();
        }
    }
}
