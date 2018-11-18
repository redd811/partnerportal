package com.codebytes.partnerportal.user.domain.rest.product;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

import com.codebytes.partnerportal.user.domain.Product;
import com.codebytes.partnerportal.user.domain.rest.ResponseBase;

@Getter
@Setter
@ToString
public class GetAllProductResponse extends ResponseBase
{
    private long productCount;
    private List<Product> productList;
}
