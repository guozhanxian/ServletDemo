package com.ralph.persist;

import com.ralph.domain.Drug;
import com.ralph.domain.Page;

import java.util.List;

/**
 * Created by guozhanxian.
 *
 * @author 果占先
 *         日期：2017-08-23
 * @version 1.0
 */
public interface DrugDao
{
    public List<Drug> findAll();

    public void insertDrug(Drug d);

    public Page<Drug> findDrugByPage(int currentPage);
}
