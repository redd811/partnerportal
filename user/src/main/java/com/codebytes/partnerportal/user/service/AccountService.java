package com.codebytes.partnerportal.user.service;

import com.codebytes.partnerportal.common.domain.common.Account;

public interface AccountService {
	boolean isUsernameExist(String username);
	boolean isEmailExist(String email);
	boolean isPasswordMatch(String password, String confirmPassword);
	Account saveOrUpdateUser(Account account);
	String hashPassword(String password);
}
