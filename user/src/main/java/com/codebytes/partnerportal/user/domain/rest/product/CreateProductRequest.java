package com.codebytes.partnerportal.user.domain.rest.product;

import com.codebytes.partnerportal.user.domain.Discount;
import com.codebytes.partnerportal.user.domain.DiscountType;
import com.codebytes.partnerportal.user.domain.rest.RequestBase;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
public class CreateProductRequest extends RequestBase
{
    private String productSKU;
    private String name;
    private String brand;
    private String description;
    private String model;
    private double price;
    private int quantity;
    private DiscountType discountType;
    private Discount discount;
    private String mainImage;
    private List<String> subImages;
}
