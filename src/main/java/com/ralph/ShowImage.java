package com.ralph;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

/**
 * Created by guozhanxian on 2017/8/11.
 */
public class ShowImage extends HttpServlet
{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        resp.setContentType("image/png");
        OutputStream os = resp.getOutputStream();

        String imgPath = "imgs/car.png";
        ServletContext ctx = getServletContext();
        String realPath = ctx.getRealPath(imgPath);
        System.out.println(realPath);

        File file = new File(realPath);
        InputStream is = new FileInputStream(file);
        byte[] res = new byte[1024*5];

        int length = 0;
        while((length=is.read(res))>0)
        {
            os.write(res,0,length);
        }

        os.flush();
        os.close();
        is.close();
    }
}
