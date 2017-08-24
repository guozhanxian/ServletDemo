package com.ralph.util;

import org.apache.commons.dbcp.BasicDataSource;

import javax.annotation.Resource;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;
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
    static BasicDataSource ds = new BasicDataSource();

    static
    {
        ResourceBundle rb = ResourceBundle.getBundle("com.ralph.res.db");
        CLASS_NAME = rb.getString("driver_class");
        DB_URL = rb.getString("db_url");
        DB_USER = rb.getString("db_user");
        DB_PWD = rb.getString("db_pwd");

        ds.setDriverClassName(CLASS_NAME);
        ds.setUrl(DB_URL);
        ds.setUsername(DB_USER);
        ds.setPassword(DB_PWD);

        ds.setInitialSize(5);
        ds.setMaxActive(8);
        ds.setMinIdle(2);
        ds.setMaxWait(3000);
    }

    public static Connection getConnection() throws Exception
    {
        Connection conn = null;
        conn = ds.getConnection();

        //使用JNDI获取容器提供的服务
//        Context ctx = new InitialContext();
//        DataSource ds2 = (DataSource) ctx.lookup("java:comp/env/jdbc/TestDB");
//        conn = ds2.getConnection();

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
