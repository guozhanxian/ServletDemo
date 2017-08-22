package com.ralph.persist;

import com.ralph.exception.DataAccessException;
import com.ralph.util.JdbcUtil;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Types;

/**
 * Created by guozhanxian.
 *
 * @author 果占先
 *         日期：2017-08-21
 * @version 1.0
 */
public class AccountDaoImpl implements AccountDao
{
    @Override
    public String change(int id1, int id2, double money)
    {
        Connection conn = null;
        CallableStatement cs = null;
        String result = "";
        try{
            conn = JdbcUtil.getConnection();
            cs = conn.prepareCall("call change(?,?,?,?)");
            cs.setInt(1,id1);
            cs.setInt(2,id2);
            cs.setDouble(3,money);

            //注册出参
            cs.registerOutParameter(4, Types.VARCHAR);

            //执行存储过程
            cs.execute();

            //获取出参
            result = cs.getString(4);
        }catch (Exception e){
            e.printStackTrace();
            throw new DataAccessException("存储过程调用失败！",e);
        }finally
        {
            JdbcUtil.closeAll(conn,cs);
        }
        return result;
    }
}
