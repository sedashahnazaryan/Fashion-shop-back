package com.example.fashionshopback.validation.commons;

import com.example.fashionshopback.model.Product;
import com.example.fashionshopback.model.commons.Image;
import com.example.fashionshopback.validation.ValidationConstants;

import java.util.LinkedList;

public final class ImageValidator {
    public static void checkDefaultImage(Product product) {
        if (product.getImg() == null) {
            product.setImg(new LinkedList<>());
            product.getImg().add(new Image(ValidationConstants.DEFAULT_IMAGE_PATH));
        }
    }
}
