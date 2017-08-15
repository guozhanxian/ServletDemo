package com.ralph;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * Created by guozhanxian.
 *
 * @author 果占先
 *         日期：2017-08-15
 * @version 1.0
 */
public class Test
{
    public static void main(String[] args)
    {
        BufferedImage image = new BufferedImage(100,100,BufferedImage.TYPE_INT_RGB);
        Graphics g = image.getGraphics();
        Font f = new Font("",Font.BOLD,20);
        g.setFont(f);
        g.setColor(new Color(200, 255, 68));
        g.drawString("7856",20,20);

//        ImageIO.write(image,"jpg",os);
    }
}
