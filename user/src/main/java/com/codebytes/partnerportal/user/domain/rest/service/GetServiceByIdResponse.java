package com.codebytes.partnerportal.user.domain.rest.service;

import com.codebytes.partnerportal.user.domain.Service;
import com.codebytes.partnerportal.user.domain.rest.ResponseBase;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class GetServiceByIdResponse extends ResponseBase
{
    private Service service;
}
