package com.example.fashionshop.validation;

import com.example.fashionshop.model.Product;
import com.example.fashionshop.validation.commons.DescriptionValidator;
import com.example.fashionshop.validation.commons.ImageValidator;
import com.example.fashionshop.validation.commons.StockValidator;

public final class ProductValidator {
    public static boolean validateUpdateProduct(Product product) {
// ImageValidator.checkDefaultImage(product);

        if (product.getName().length() == 0 ||
                product.getPrice() < 0 ||
                !StockValidator.validateStock(product.getStock()) ||
                !DescriptionValidator.validateDescription(product.getDescription())) {
            return false;
        }
        return true;

    }

    public static boolean validateCreateProduct(Product product) {
        return validateUpdateProduct(product);
    }
}
