package com.fawry.ecommerce.interfaces;

import java.time.LocalDate;

public interface Expiration {
    LocalDate getExpiryDate();
    boolean isExpired();
}
