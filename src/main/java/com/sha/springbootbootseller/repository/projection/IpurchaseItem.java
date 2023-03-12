package com.sha.springbootbootseller.repository.projection;

import java.time.LocalDateTime;

public interface IpurchaseItem {
    String getTitle();
    Double getPrice();
    LocalDateTime getPurchaseTime();
}
