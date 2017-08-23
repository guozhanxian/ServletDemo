package com.ralph.util;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * Created by guozhanxian.
 *
 * @author 果占先
 *         日期：2017-08-23
 * @version 1.0
 */

public class ContextLoaderListener implements ServletContextListener
{
    public void contextInitialized(ServletContextEvent servletContextEvent)
    {
        //容器启动执行
        ServletContext ctx = servletContextEvent.getServletContext();
        System.out.println("系统已经启动。");
    }

    public void contextDestroyed(ServletContextEvent servletContextEvent)
    {

    }
}
