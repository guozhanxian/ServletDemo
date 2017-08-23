package com.ralph.util;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import java.io.IOException;

/**
 * Created by guozhanxian.
 *
 * @author 果占先
 *         日期：2017-08-23
 * @version 1.0
 */
@WebFilter(filterName = "EncodeFilter",urlPatterns = "/*")
@WebInitParam(name="encode",value = "utf-8")
public class EncodingFilter implements Filter
{
    private String encoding = "utf-8";

    public void init(FilterConfig filterConfig) throws ServletException
    {
        String str = filterConfig.getInitParameter("encode");
        if(str != null && str.length()>0)
            encoding = str;
    }

    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException
    {
        servletRequest.setCharacterEncoding(encoding);
        filterChain.doFilter(servletRequest,servletResponse);

    }

    public void destroy()
    {
    }
}
