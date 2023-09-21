package com.example.datasource.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.datasource.model.PurchaseModel;
import com.example.datasource.repository.Purchase;

@RestController
@RequestMapping("/purchase")
public class PurchaseController {
  private final Purchase purchaseRepository;

  public PurchaseController(Purchase p)
  {
    this.purchaseRepository=p;
  }

  @GetMapping("/GetAllPurchases")
  public List<PurchaseModel> GetAllPurchases()
  {
    purchaseRepository.GetAllPurchases();
    List<PurchaseModel> dummy = new ArrayList<>();
    return dummy;
  }

  @PostMapping("/savePurchase")
  public void savePurchase(@RequestBody PurchaseModel purchasedata)
  {
    // PurchaseModel purchasedata = new PurchaseModel();
    // purchasedata.setProduct(product);
    // purchasedata.setPrice(price);
    purchaseRepository.storePurchase(purchasedata);
  }
}
