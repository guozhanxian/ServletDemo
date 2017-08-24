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
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
@WebServlet("/addDrug.action")
public class AddDrug extends HttpServlet
{
    private static final Logger log = LoggerFactory.getLogger(AddDrug.class);

    private BaseInfoManager baseInfoManager = new BaseInfoManagerImpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        String drugId = "";
        String drugName = "";
        String drugPrice = "";
        String drugDate = "";
        String drugPic = "";

        try{

            //创建DiskFileItemFactory，工厂对象（实现了工厂模式的对象）。该对象可以制造其他对象
            DiskFileItemFactory dfif = new DiskFileItemFactory();
            dfif.setSizeThreshold(Constants.THRESHOLD_FILE_SIZE);
            dfif.setRepository(new File(System.getProperty("java.io.tmpdir")));

            //创建ServletFileUpload
            ServletFileUpload sfu = new ServletFileUpload(dfif);
            sfu.setHeaderEncoding("utf-8");
            List<FileItem> list = sfu.parseRequest(req);

            for(FileItem fi:list)
            {
                if(fi.isFormField()){
                    //用户输入的信息
                    String name = fi.getFieldName();
                    if("drugId".equals(name)){
                        drugId = fi.getString("utf-8");
                    }else if("drugName".equals(name)){
                        drugName = fi.getString("utf-8");
                    }else if("drugPrice".equals(name)){
                        drugPrice = fi.getString("utf-8");
                    }else if("drugDate".equals(name)){
                        drugDate = fi.getString("utf-8");
                    }
                }else{
                    //上传的文件信息
                    drugPic = new File(fi.getName()).getName();
                    String realPath = getServletContext().getRealPath("upload");
                    File dir = new File(realPath+File.separator+drugId);
                    if(!dir.exists())
                        dir.mkdir();

                    File file = new File(realPath+File.separator+drugId+File.separator+drugPic);
                    if(file.exists())
                        file.delete();
                    file.createNewFile();

                    InputStream is = fi.getInputStream();
                    OutputStream os = new FileOutputStream(file);
                    byte[] res = new byte[1024*3];
                    int length = 0;
                    while((length = is.read(res))>0)
                    {
                        os.write(res,0,length);
                    }
                    os.flush();
                    os.close();
                    is.close();
                }
            }


            Drug d = new Drug();
            d.setDrug_id(Integer.parseInt(drugId));
            d.setDrug_name(drugName);
            d.setDrug_price(Double.parseDouble(drugPrice));
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            d.setDrug_date(new Date(sdf.parse(drugDate).getTime()));
            d.setDrug_pic(drugPic);

            baseInfoManager.addDrugInfo(d);
            resp.sendRedirect("findDrugs.action");

        }catch (Exception e){
            log.error("添加药品信息失败",e);
            resp.sendRedirect("error.jsp");
        }
    }
}
