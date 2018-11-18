package com.codebytes.partnerportal.partner.service;

import com.codebytes.partnerportal.common.domain.partner.PartnerBrand;

public interface SellerService {
    boolean isUsernameExist(String username);
    boolean isEmailExist(String email);
    boolean isPasswordMatch(String password, String confirmPassword);
    PartnerBrand saveOrUpdateUser(PartnerBrand partnerBrand);
    PartnerBrand getInformationOfLoggedInUser(String username);
    String hashPassword(String password);
}
