package com.codebytes.partnerportal.user.domain.rest.product;

import com.codebytes.partnerportal.user.domain.rest.RequestBase;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@ToString
public class GetProductByIdRequest extends RequestBase
{
    private long productId;
}
