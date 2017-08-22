package com.ralph.exception;

/**
 * Created by guozhanxian.
 *
 * @author 果占先
 *         日期：2017-08-14
 * @version 1.0
 */
public class DataAccessException extends RuntimeException
{
    public DataAccessException()
    {
        super();
    }

    public DataAccessException(String msg)
    {
        super(msg);
    }

    public DataAccessException(String msg,Throwable e)
    {
        super(msg,e);
    }
}
