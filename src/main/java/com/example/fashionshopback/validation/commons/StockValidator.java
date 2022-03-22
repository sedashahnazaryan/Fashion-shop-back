package com.example.fashionshopback.validation.commons;

import com.example.fashionshopback.model.commons.Stock;

public  final class StockValidator {
    public static boolean validateStock(Stock stock) {
        if (stock.getCount() < 0) return false;
        stock.setIsAvailable(stock.getCount() > 0);
        return true;
    }
}
