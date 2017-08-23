package com.ralph.web;

import com.ralph.domain.Drug;
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
import java.sql.Date;
import java.text.SimpleDateFormat;

/**
 * Created by guozhanxian.
 *
 * @author 果占先
 *         日期：2017-08-23
 * @version 1.0
 */
@WebServlet("/addDrug.action")
public class AddDrug extends HttpServlet
{
    private static final Logger log = LoggerFactory.getLogger(AddDrug.class);

    private BaseInfoManager baseInfoManager = new BaseInfoManagerImpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        String drugId = req.getParameter("drugId");
        String drugName = req.getParameter("drugName");
        String drugPrice = req.getParameter("drugPrice");
        String drugDate = req.getParameter("drugDate");

        try{
            Drug d = new Drug();
            d.setDrug_id(Integer.parseInt(drugId));
            d.setDrug_name(drugName);
            d.setDrug_price(Double.parseDouble(drugPrice));
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            d.setDrug_date(new Date(sdf.parse(drugDate).getTime()));

            baseInfoManager.addDrugInfo(d);
            resp.sendRedirect("findDrugs.action");

        }catch (Exception e){
            log.error("添加药品信息失败",e);
            resp.sendRedirect("error.jsp");
        }
    }
}
