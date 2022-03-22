package com.example.fashionshopback.model;

import com.example.fashionshopback.model.commons.Description;
import com.example.fashionshopback.model.commons.Image;
import com.example.fashionshopback.model.commons.Stock;
import com.example.fashionshopback.model.commons.enums.Currency;


import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@Data
@ToString
@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    private Float price;

    @OneToOne(cascade = CascadeType.ALL)
    private Description description;

    @Enumerated(EnumType.STRING)
    private Currency currency;

    @OneToOne(cascade = CascadeType.ALL)
    private Stock stock;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Image> img;

}
