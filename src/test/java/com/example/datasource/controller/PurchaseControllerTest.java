package com.example.datasource.controller;

import static org.mockito.Mockito.mock;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.BDDMockito.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.example.datasource.model.PurchaseModel;
import com.example.datasource.repository.Purchase;

 //@ExtendWith(MockitoExtension.class)
@SpringBootTest
 public class PurchaseControllerTest {
  
 // @Mock
 @MockBean
  private Purchase mockpurchaseRepository;
  //@InjectMocks 
  @Autowired
  private PurchaseController purchaseController;

  @Test 
  @DisplayName("GetAllPurchasesTest")
 
  public void GetAllPurchasesTest()
  {
    //Purchase mockpurchaseRepository = mock(Purchase.class);
    //PurchaseController purchaseController = new PurchaseController(mockpurchaseRepository);
    //returns
    PurchaseModel purchase1=new PurchaseModel();
    purchase1.setId(1);
    purchase1.setProduct("product1");
    purchase1.setPrice(new BigDecimal(25));

    List<PurchaseModel> PurchaseList = new ArrayList<PurchaseModel>();

    PurchaseList.add(purchase1);

    given(mockpurchaseRepository.GetAllPurchases()).willReturn(PurchaseList);

    List<PurchaseModel> returnPurchases = purchaseController.GetAllPurchases();

    // verify that the mock repository GetAllPurchases was called
    verify(mockpurchaseRepository).GetAllPurchases();
    // verify that the controller.GetAllPurchases returns the 
    // list returned by the mockRepository GetAllPurchases
   // assertEquals(returnPurchases, PurchaseList);
  }
}
