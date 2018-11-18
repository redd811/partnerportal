package com.codebytes.partnerportal.user.domain.rest.service;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

import com.codebytes.partnerportal.user.domain.ContactDetails;
import com.codebytes.partnerportal.user.domain.Discount;
import com.codebytes.partnerportal.user.domain.DiscountType;
import com.codebytes.partnerportal.user.domain.rest.RequestBase;

@Getter
@Setter
@ToString
public class UpdateServiceByIdRequest extends RequestBase
{
    private long serviceId;

    private String serviceName;
    private String description;
    private String location;

    private double price;

    private DiscountType discountType;

    private Discount discount;
    private ContactDetails contactDetails;

    private String mainImage;
    private List<String> subImages;
}
