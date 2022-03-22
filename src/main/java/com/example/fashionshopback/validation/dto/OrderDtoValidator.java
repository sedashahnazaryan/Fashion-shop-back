package com.example.fashionshopback.validation.dto;

import com.example.fashionshopback.model.dto.request.Dto.OrderUpdateReqDto;
import com.example.fashionshopback.validation.ValidationConstants;

public final class OrderDtoValidator {
    public static boolean chekOrderUpdateDto(OrderUpdateReqDto dto) {
        return dto.getCount() >= ValidationConstants.ORDER_PRODUCT_COUNT_MIN_VALUE &&
                dto.getCount() <= ValidationConstants.ORDER_PRODUCT_COUNT_MAX_VALUE;
    }
}
