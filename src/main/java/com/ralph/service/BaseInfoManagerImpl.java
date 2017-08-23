package com.ralph.service;

import com.ralph.domain.Drug;
import com.ralph.domain.Page;
import com.ralph.persist.DrugDao;
import com.ralph.persist.DrugDaoImpl;

import java.util.List;

/**
 * Created by guozhanxian.
 *
 * @author 果占先
 *         日期：2017-08-23
 * @version 1.0
 */
public class BaseInfoManagerImpl implements BaseInfoManager
{
    private DrugDao drugDao = new DrugDaoImpl();

    public List<Drug> findAllDrugs()
    {
        return drugDao.findAll();
    }

    public void addDrugInfo(Drug d)
    {
        drugDao.insertDrug(d);
    }

    public Page<Drug> findDrugByPage(int currentPage)
    {
        return drugDao.findDrugByPage(currentPage);
    }
}
