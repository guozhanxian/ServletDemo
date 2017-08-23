package com.ralph.util;

import javax.annotation.Resource;
import java.sql.*;
import java.util.ResourceBundle;

/**
 * Created by guozhanxian.
 *
 * @author 果占先
 *         日期：2017-08-14
 * @version 1.0
 */
public class JdbcUtil
{

    static String CLASS_NAME;
    static String DB_URL;
    static String DB_USER;
    static String DB_PWD;

    static
    {
        ResourceBundle rb = ResourceBundle.getBundle("com.ralph.res.db");
        CLASS_NAME = rb.getString("driver_class");
        DB_URL = rb.getString("db_url");
        DB_USER = rb.getString("db_user");
        DB_PWD = rb.getString("db_pwd");
    }

    public static Connection getConnection() throws Exception
    {
        Connection conn = null;
        Class.forName(CLASS_NAME);
        conn = DriverManager.getConnection(DB_URL,DB_USER,DB_PWD);

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
