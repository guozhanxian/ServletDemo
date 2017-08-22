package com.ralph.service;

import com.ralph.persist.AccountDao;
import com.ralph.persist.AccountDaoImpl;

/**
 * Created by guozhanxian.
 *
 * @author 果占先
 *         日期：2017-08-21
 * @version 1.0
 */
public class CountManagerImpl implements CountManager
{
    private AccountDao accountDao = new AccountDaoImpl();
    @Override
    public String change(int id1, int id2, double money)
    {
        return accountDao.change(id1,id2,money);
    }
}
