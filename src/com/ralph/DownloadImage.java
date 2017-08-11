package com.ralph;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * Created by guozhanxian on 2017/8/11.
 */
public class DownloadImage extends HttpServlet
{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        resp.setContentType("bin");
        resp.addHeader("Content-Disposition","attachment;filename=\"car.png\"");

        OutputStream os = resp.getOutputStream();

        String path = getServletContext().getRealPath("imgs/car.png");
        InputStream is = new FileInputStream(path);

        byte[] res = new byte[1024*3];
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
