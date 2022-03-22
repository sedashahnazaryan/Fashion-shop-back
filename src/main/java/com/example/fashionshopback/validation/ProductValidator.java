package com.example.fashionshopback.validation;

import com.example.fashionshopback.model.Product;
import com.example.fashionshopback.validation.commons.DescriptionValidator;
import com.example.fashionshopback.validation.commons.ImageValidator;
import com.example.fashionshopback.validation.commons.StockValidator;

public final class ProductValidator {
    public static boolean validateUpdateProduct(Product product) {
        ImageValidator.checkDefaultImage(product);

        return product.getName().length() != 0 &&
                product.getPrice() >= 0 &&
                StockValidator.validateStock(product.getStock()) &&
                DescriptionValidator.validateDescription(product.getDescription());

    }

    public static boolean validateCreateProduct(Product product) {
        return validateUpdateProduct(product);
    }


}
