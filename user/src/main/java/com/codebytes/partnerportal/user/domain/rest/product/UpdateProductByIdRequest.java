package com.codebytes.partnerportal.user.domain.rest.product;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

import com.codebytes.partnerportal.user.domain.Discount;
import com.codebytes.partnerportal.user.domain.DiscountType;
import com.codebytes.partnerportal.user.domain.rest.RequestBase;

@Getter
@Setter
@ToString
public class UpdateProductByIdRequest extends RequestBase
{
    private long productId;
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
