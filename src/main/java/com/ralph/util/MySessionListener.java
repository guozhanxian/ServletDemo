package com.ralph.util;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * Created by guozhanxian.
 *
 * @author 果占先
 *         日期：2017-08-23
 * @version 1.0
 */
public class MySessionListener implements HttpSessionListener
{
    public void sessionCreated(HttpSessionEvent httpSessionEvent)
    {

    }

    public void sessionDestroyed(HttpSessionEvent httpSessionEvent)
    {
        HttpSession session = httpSessionEvent.getSession();
        session.getAttribute("user");
    }
}
