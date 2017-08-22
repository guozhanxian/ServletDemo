package com.ralph.persist;

import com.ralph.domain.Student;
import com.ralph.exception.DataAccessException;
import com.ralph.util.JdbcUtil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by guozhanxian.
 *
 * @author 果占先
 *         日期：2017-08-14
 * @version 1.0
 */
public class StudentDaoImpl implements StudentDao
{
    public void insert(Student s)
    {
        Connection conn = null;
        PreparedStatement ps = null;
        try
        {
            conn = JdbcUtil.getConnection();
            ps = conn.prepareStatement("insert into students(name,age) VALUES(?,?) ");
            ps.setString(1,s.getName());
            ps.setInt(2,s.getAge());

            ps.executeUpdate();
        }catch (Exception e){
            e.printStackTrace();
            throw new DataAccessException("学生插入失败！",e);
        }finally
        {
            JdbcUtil.closeAll(conn,ps);
        }
    }

    public List<Student> findAllStudents()
    {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Student> list = new ArrayList<Student>();
        try
        {
            conn = JdbcUtil.getConnection();
            ps = conn.prepareStatement("select * from students");

            rs = ps.executeQuery();
            while(rs.next())
            {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                int age = rs.getInt("age");

                Student s = new Student(id,name,age);
                list.add(s);
            }
        }catch (Exception e){
            e.printStackTrace();
            throw new DataAccessException("学生插入失败！",e);
        }finally
        {
            JdbcUtil.closeAll(conn,ps,rs);
        }
        return list;
    }
}
