package com.ralph.domain;

import java.sql.Date;

public class Drug {
  private Integer drug_id;
  private String drug_name;
  private Double drug_price;
  private java.sql.Date drug_date;

  public Integer getDrug_id()
  {
    return drug_id;
  }

  public void setDrug_id(Integer drug_id)
  {
    this.drug_id = drug_id;
  }

  public String getDrug_name()
  {
    return drug_name;
  }

  public void setDrug_name(String drug_name)
  {
    this.drug_name = drug_name;
  }

  public Double getDrug_price()
  {
    return drug_price;
  }

  public void setDrug_price(Double drug_price)
  {
    this.drug_price = drug_price;
  }

  public Date getDrug_date()
  {
    return drug_date;
  }

  public void setDrug_date(Date drug_date)
  {
    this.drug_date = drug_date;
  }
}
