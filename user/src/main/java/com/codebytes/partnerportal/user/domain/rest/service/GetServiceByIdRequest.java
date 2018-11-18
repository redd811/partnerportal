package com.codebytes.partnerportal.user.domain.rest.service;

import com.codebytes.partnerportal.user.domain.rest.RequestBase;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class GetServiceByIdRequest extends RequestBase
{
    private long serviceId;
}
