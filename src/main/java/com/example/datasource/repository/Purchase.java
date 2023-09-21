package com.example.datasource.repository;


import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.example.datasource.model.PurchaseModel;

@Repository
public class Purchase {
   private final JdbcTemplate jdbcTemplt;

  public Purchase(JdbcTemplate jdbc)
  {
    this.jdbcTemplt = jdbc;
  }

  public void storePurchase(PurchaseModel purchase)
  {
    String sqlStmt = "INSERT INTO purchase VALUES (?,?,?)";

    jdbcTemplt.update(sqlStmt,purchase.getId(),purchase.getProduct(), purchase.getPrice());

  }

  public List<PurchaseModel> GetAllPurchases()
  {
    String sqlStmt = "SELECT * FROM PURCHASE";

    RowMapper<PurchaseModel> purchaseRowMapper =(r,i)->{
      PurchaseModel rowobj = new PurchaseModel();
      //rowobj.setId(r.getInt("id"));
      rowobj.setProduct(r.getString("product"));
      rowobj.setPrice(r.getBigDecimal("price"));
      return rowobj;

    };

    return jdbcTemplt.query(sqlStmt,purchaseRowMapper);
  
  }
}
