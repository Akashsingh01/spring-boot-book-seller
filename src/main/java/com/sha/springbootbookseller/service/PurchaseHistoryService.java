package com.sha.springbootbookseller.service;

import com.sha.springbootbookseller.repository.IPurchaseHistoryRepository;
import com.sha.springbootbookseller.repository.projection.IPurchaseItem;
import org.springframework.beans.factory.annotation.Autowired;
import com.sha.springbootbookseller.model.PurchaseHistory;

import java.time.LocalDateTime;
import java.util.List;

public class PurchaseHistoryService implements  IPurchaseHistoryService
{

    @Autowired
    private final IPurchaseHistoryRepository purchaseHistoryRepository;


    public  PurchaseHistoryService(IPurchaseHistoryRepository purchaseHistoryRepository) {
        this.purchaseHistoryRepository = purchaseHistoryRepository;
    }

    @Override
    public PurchaseHistory savePurchaseHistory(PurchaseHistory purchaseHistory)
    {
        purchaseHistory.setPurchaseTime(LocalDateTime.now());
        return purchaseHistoryRepository.save(purchaseHistory);
    }


    public List<IPurchaseItem> findPurchasedItemsOfUser (Long userId)
    {
        return purchaseHistoryRepository.findAllPurchaseofUser(userId);
    }

}
