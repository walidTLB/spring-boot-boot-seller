package com.sha.springbootbootseller.service;

import com.sha.springbootbootseller.model.PurchaseHistory;
import com.sha.springbootbootseller.repository.projection.IpurchaseItem;

import java.util.List;

public interface IPurchaseHistoryService {
    PurchaseHistory savePurchaseHistory(PurchaseHistory purchaseHistory);

    List<IpurchaseItem> findPurchasedItemsOfUser(Long userId);
}
