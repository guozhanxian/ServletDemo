package com.ralph.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by guozhanxian.
 *
 * @author 果占先
 *         日期：2017-08-23
 * @version 1.0
 */
public class Page<E> implements Serializable
{
    private List<E> list = new ArrayList<E>();
    private int totalPage;
    private int currentPage;
    private int totalNumber;

    public List<E> getList()
    {
        return list;
    }

    public void setList(List<E> list)
    {
        this.list = list;
    }

    public int getTotalPage()
    {
        return totalPage;
    }

    public void setTotalPage(int totalPage)
    {
        this.totalPage = totalPage;
    }

    public int getCurrentPage()
    {
        return currentPage;
    }

    public void setCurrentPage(int currentPage)
    {
        this.currentPage = currentPage;
    }

    public int getTotalNumber()
    {
        return totalNumber;
    }

    public void setTotalNumber(int totalNumber)
    {
        this.totalNumber = totalNumber;
    }
}
