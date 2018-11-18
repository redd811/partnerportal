package com.codebytes.partnerportal.partner.service;

import com.codebytes.partnerportal.common.domain.partner.PartnerBrand;
import com.codebytes.partnerportal.partner.repository.SellerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class SellerServiceImpl implements SellerService {

    @Autowired
    private SellerRepository sellerRepository;

    @Autowired
    private PasswordEncoder encoder;

    @Override
    public boolean isUsernameExist(String username) {
        return  sellerRepository.existsByUsername(username);
    }

    @Override
    public boolean isEmailExist(String email) {
        return sellerRepository.existsByEmail(email);
    }

    @Override
    public boolean isPasswordMatch(String password, String confirmPassword) {
        return password.equals(confirmPassword);
    }

    @Override
    public PartnerBrand saveOrUpdateUser(PartnerBrand partnerBrand) {
        return sellerRepository.save(partnerBrand);
    }

    @Override
    public PartnerBrand getInformationOfLoggedInUser(String username) {
        return sellerRepository.getInformationOfLoggedInUser(username);
    }

    @Override
    public String hashPassword(String password) {
        return encoder.encode(password);
    }
}
