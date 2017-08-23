package com.ralph.web;

import com.ralph.domain.Drug;
import com.ralph.domain.Page;
import com.ralph.service.BaseInfoManager;
import com.ralph.service.BaseInfoManagerImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by guozhanxian.
 *
 * @author 果占先
 *         日期：2017-08-23
 * @version 1.0
 */
@WebServlet("/findDrugs.action")
public class FindDrugs extends HttpServlet
{
    private static final Logger log = LoggerFactory.getLogger(FindDrugs.class);

    private BaseInfoManager baseInfoManager = new BaseInfoManagerImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        try
        {
            int page = 1;
            String p = req.getParameter("page");
            if(p!=null && p.length()>0)
                page = Integer.parseInt(p);

            Page<Drug> pList = baseInfoManager.findDrugByPage(page);
            req.setAttribute("p",pList);
            req.getRequestDispatcher("viewDrug.jsp").forward(req,resp);
        }catch (Exception e){
            log.error("查询药品信息失败",e);
            resp.sendRedirect("error.jsp");
        }
    }
}
