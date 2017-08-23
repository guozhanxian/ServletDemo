package com.ralph.service;

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
public interface BaseInfoManager
{
    public List<Drug> findAllDrugs();

    public void addDrugInfo(Drug d);

    public Page<Drug> findDrugByPage(int currentPage);
}
