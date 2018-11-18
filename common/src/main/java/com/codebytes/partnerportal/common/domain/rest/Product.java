package com.codebytes.partnerportal.common.domain.rest;

import com.codebytes.partnerportal.common.domain.Discount;
import com.codebytes.partnerportal.common.domain.DiscountType;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;
import java.util.List;

@Setter
@Getter
@EqualsAndHashCode
@ToString
public class Product {
    private long productId;
    private long storeId;

    private String sku;
    private String name;
    private String brand;
    private String description;
    private String model;

    private int quantity;

    private double price;
    private DiscountType discountType;
    private Discount discount;
    private String mainImage;
    private List<String> subImages;

    private LocalDateTime dateCreated;
}
