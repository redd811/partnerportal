package com.codebytes.partnerportal.user.service;

import com.codebytes.partnerportal.common.domain.user.Customer;

public interface CustomerService {
	boolean isUsernameExist(String username);
	boolean isEmailExist(String email);
	boolean isPasswordMatch(String password, String confirmPassword);
	Customer saveOrUpdateUser(Customer account);
	String hashPassword(String password);
}
