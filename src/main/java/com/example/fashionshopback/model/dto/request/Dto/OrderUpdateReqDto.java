package com.example.fashionshopback.model.dto.request.Dto;

import com.example.fashionshopback.model.commons.enums.OrderStatus;
import lombok.Data;
import lombok.ToString;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Data
@ToString
public class OrderUpdateReqDto {

    private Integer count;

    @Enumerated(EnumType.STRING)
    private OrderStatus orderStatus;
}
