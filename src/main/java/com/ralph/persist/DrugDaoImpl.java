package com.ralph.persist;

import com.ralph.domain.Drug;
import com.ralph.domain.Page;
import com.ralph.exception.DataAccessException;
import com.ralph.util.Constants;
import com.ralph.util.JdbcUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by guozhanxian.
 *
 * @author 果占先
 *         日期：2017-08-23
 * @version 1.0
 */
public class DrugDaoImpl implements DrugDao
{
    private static final Logger log = LoggerFactory.getLogger(DrugDaoImpl.class);

    public List<Drug> findAll()
    {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Drug> list = new ArrayList<Drug>();
        try{
            conn = JdbcUtil.getConnection();
            ps = conn.prepareStatement("select * from drug");
            rs = ps.executeQuery();

            while(rs.next())
            {
                Drug d = new Drug();
                d.setDrug_id(rs.getInt("drug_id"));
                d.setDrug_name(rs.getString("drug_name"));
                d.setDrug_price(rs.getDouble("drug_price"));
                d.setDrug_date(rs.getDate("drug_date"));

                list.add(d);
            }
        }catch (Exception e){
            log.error("药品信息查询失败！",e);
            throw new DataAccessException();
        }
        return list;
    }

    public void insertDrug(Drug d)
    {
        Connection conn = null;
        PreparedStatement ps = null;
        try
        {
            conn = JdbcUtil.getConnection();
            ps = conn.prepareStatement("insert into drug values(?,?,?,?)");
            ps.setInt(1,d.getDrug_id());
            ps.setString(2,d.getDrug_name());
            ps.setDouble(3,d.getDrug_price());
            ps.setDate(4,d.getDrug_date());

            ps.executeUpdate();
        }catch (Exception e){
            log.error("添加药品信息失败",e);
            throw new DataAccessException("添加药品失败",e);
        }
    }

    public Page<Drug> findDrugByPage(int currentPage)
    {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Page<Drug> p = new Page<Drug>();
        List<Drug> list = new ArrayList<Drug>();
        try
        {
            p.setCurrentPage(currentPage);
            conn = JdbcUtil.getConnection();
            ps = conn.prepareStatement("select count(*) from DRUG");
            rs = ps.executeQuery();

            int totalNumber = 0;
            while(rs.next())
            {
                totalNumber = (int) rs.getLong(1);
            }

            p.setTotalNumber(totalNumber);
            int totalPage = (int) Math.ceil(totalNumber*1.0/ Constants.ITEM_PER_PAGE);
            p.setTotalPage(totalPage);

            ps = conn.prepareStatement("select t.* from (select rownum rn,d.* from drug d) t where t.rn between ? and ?");
            int from = (currentPage-1)*Constants.ITEM_PER_PAGE+1;
            int to  = from + Constants.ITEM_PER_PAGE-1;
            ps.setInt(1,from);
            ps.setInt(2,to);

            rs = ps.executeQuery();
            while(rs.next())
            {
                Drug d = new Drug();
                d.setDrug_id(rs.getInt("drug_id"));
                d.setDrug_name(rs.getString("drug_name"));
                d.setDrug_price(rs.getDouble("drug_price"));
                d.setDrug_date(rs.getDate("drug_date"));

                list.add(d);
            }

            p.setList(list);
        }catch (Exception e){
            log.error("分页查询失败",e);
            throw new DataAccessException("分页查询失败",e);
        }

        return p;
    }
}
