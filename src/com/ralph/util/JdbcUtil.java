package com.ralph.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * Created by guozhanxian.
 *
 * @author 果占先
 *         日期：2017-08-14
 * @version 1.0
 */
public class JdbcUtil
{
    public static Connection getConnection() throws Exception
    {
        Connection conn = null;
        Class.forName("com.mysql.jdbc.Driver");
        conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/hello??useUnicode=true&characterEncoding=utf-8","root","mysql");
        return conn;
    }

    public static void closeAll(Connection conn, PreparedStatement ps)
    {
        try{
            if(ps!=null)
                ps.close();
            if(conn!=null)
                conn.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void closeAll(Connection conn, PreparedStatement ps, ResultSet rs)
    {
        try{
            if(rs != null)
                rs.close();
            if(ps!=null)
                ps.close();
            if(conn!=null)
                conn.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
