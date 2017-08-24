package com.ralph.web;

import com.ralph.domain.Drug;
import com.ralph.service.BaseInfoManager;
import com.ralph.service.BaseInfoManagerImpl;
import com.ralph.util.Constants;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.*;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.List;

/**
 * Created by guozhanxian.
 *
 * @author 果占先
 *         日期：2017-08-23
 * @version 1.0
 */
@WebServlet("/addDrug2.action")
@MultipartConfig
public class AddDrug2 extends HttpServlet
{
    private static final Logger log = LoggerFactory.getLogger(AddDrug2.class);

    private BaseInfoManager baseInfoManager = new BaseInfoManagerImpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        String drugId = req.getParameter("drugId");
        String drugName = req.getParameter("drugName");
        String drugPrice = req.getParameter("drugPrice");
        String drugDate = req.getParameter("drugDate");
        String drugPic = "";

        try
        {
            Part p = req.getPart("drugPic");
            //获取文件名字
            drugPic = getFileName(p);

            String realPath = getServletContext().getRealPath("upload");
            File dir = new File(realPath+File.separator+drugId);
            if(!dir.exists())
                dir.mkdir();

            File file = new File(realPath+File.separator+drugId+File.separator+drugPic);
            if(file.exists())
                file.delete();
            file.createNewFile();
            //把数据存储到文件
            p.write(file.getAbsolutePath());

            Drug d = new Drug();
            d.setDrug_id(Integer.parseInt(drugId));
            d.setDrug_name(drugName);
            d.setDrug_price(Double.parseDouble(drugPrice));
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            d.setDrug_date(new Date(sdf.parse(drugDate).getTime()));
            d.setDrug_pic(drugPic);

            baseInfoManager.addDrugInfo(d);
            resp.sendRedirect("findDrugs.action");

        } catch (Exception e)
        {
            log.error("添加药品信息失败", e);
            resp.sendRedirect("error.jsp");
        }
    }

    private String getFileName(Part part)
    {
        String header = part.getHeader("Content-Disposition");
        String fileName = header.substring(header.indexOf("filename=\"") + 10,
                header.lastIndexOf("\""));
        return fileName;
    }

}
