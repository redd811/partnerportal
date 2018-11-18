package com.codebytes.partnerportal.user.domain.rest.store;

import com.codebytes.partnerportal.user.domain.CompanyDetails;
import com.codebytes.partnerportal.user.domain.Store;
import com.codebytes.partnerportal.user.domain.rest.ResponseBase;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class GetStoreInfoByUserIdResponse extends ResponseBase
{
    private Store store;
    private CompanyDetails companyDetails;
}
