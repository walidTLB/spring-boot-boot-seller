package com.sha.springbootbootseller.service;

import com.sha.springbootbootseller.model.PurchaseHistory;
import com.sha.springbootbootseller.repository.IPurchaseHistoryRepository;
import com.sha.springbootbootseller.repository.projection.IpurchaseItem;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
@Service
public class PurchaseHistoryService implements IPurchaseHistoryService{
    private final IPurchaseHistoryRepository purchaseHistoryRepository;

    public PurchaseHistoryService(IPurchaseHistoryRepository purchaseHistoryRepository) {
        this.purchaseHistoryRepository = purchaseHistoryRepository;
    }

    @Override
public PurchaseHistory savePurchaseHistory(PurchaseHistory purchaseHistory){
    purchaseHistory.setPurchaseTime(LocalDateTime.now());
    return purchaseHistoryRepository.save(purchaseHistory);
}
@Override
public List<IpurchaseItem> findPurchasedItemsOfUser(Long userId) {
        return purchaseHistoryRepository.findAllPurchasesOfUsers(userId);
}
}
