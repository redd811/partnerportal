package com.codebytes.partnerportal.user.domain.rest.service;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

import com.codebytes.partnerportal.user.domain.Service;
import com.codebytes.partnerportal.user.domain.rest.ResponseBase;

@Getter
@Setter
@ToString
public class GetAllServiceResponse
        extends ResponseBase
{
    private long productCount;
    private List<Service> serviceList;
}
