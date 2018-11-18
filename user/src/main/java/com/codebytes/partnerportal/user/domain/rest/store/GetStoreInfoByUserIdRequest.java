package com.codebytes.partnerportal.user.domain.rest.store;

import com.codebytes.partnerportal.user.domain.rest.RequestBase;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class GetStoreInfoByUserIdRequest extends RequestBase
{
    private long userId;
}
