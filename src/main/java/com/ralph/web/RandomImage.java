package com.ralph.web;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Random;

/**
 * Created by guozhanxian.
 *
 * @author 果占先
 *         日期：2017-08-15
 * @version 1.0
 */
@WebServlet("/randomImage.action")
public class RandomImage extends HttpServlet
{
    private String[] arr = {"A","B","C","D","E","F","G","H","I","J","K","L","M","N","P","Q","R","S","T","U","V","W","X","Y","Z","1","2","3","4","5","6","7","8","9"};
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        Random r = new Random();
        int x = r.nextInt(arr.length);
        int y = r.nextInt(arr.length);
        int z = r.nextInt(arr.length);
        int m = r.nextInt(arr.length);

        String str = arr[x]+arr[y]+arr[z]+arr[m];
        BufferedImage image = new BufferedImage(100,80,BufferedImage.TYPE_INT_ARGB);
        Graphics g = image.getGraphics();
        g.setColor(new Color(57, 221, 255));
        g.drawString(str,20,50);

        resp.setContentType("image/png");
        OutputStream os = resp.getOutputStream();
        ImageIO.write(image,"png",os);
        os.flush();
        os.close();
    }
}
