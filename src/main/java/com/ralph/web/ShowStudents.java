package com.ralph.web;

import com.ralph.domain.Student;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by guozhanxian.
 *
 * @author 果占先
 *         日期：2017-08-22
 * @version 1.0
 */
@WebServlet("/showStudents.action")
public class ShowStudents extends HttpServlet
{
    private static final Logger log = LoggerFactory.getLogger(ShowStudents.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        log.debug("进入ShowStudents中，开始处理！");
        Student s1 = new Student(1,"张三",22);
        Student s2 = new Student(12,"李四",23);
        Student s3 = new Student(5,"王五",22);

        log.debug("学生1姓名="+s1.getName());

        try{
            List<Student> list = new ArrayList<Student>();
            list.add(s1);
            list.add(s2);
            list.add(s3);

            req.setAttribute("list",list);
            req.getRequestDispatcher("showStudents.jsp").forward(req,resp);
        }catch (Exception e){
            resp.sendRedirect("error.jsp");
            log.error("查询学生信息失败!",e);
        }
    }
}
