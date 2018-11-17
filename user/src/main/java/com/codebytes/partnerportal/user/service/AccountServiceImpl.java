package com.codebytes.partnerportal.user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.codebytes.partnerportal.common.domain.common.Account;
import com.codebytes.partnerportal.user.repository.AccountRepository;

@Service
public class AccountServiceImpl implements AccountService {
	
	@Autowired
	private PasswordEncoder encoder;
	
	@Autowired
	AccountRepository accountRepository;

	@Override
	public boolean isUsernameExist(String username) {
		//return accountRepository.existsByUsername(username);
		return false;
	}

	@Override
	public boolean isEmailExist(String email) {
		//return accountRepository.existsByEmail(email);
		return false;
	}
	
	@Override
	public boolean isPasswordMatch(String password, String confirmPassword) {
		return password.equals(confirmPassword);
	}

	@Override
	public Account saveOrUpdateUser(Account account) {
		return accountRepository.save(account);
	}

	@Override
	public String hashPassword(String password) {
		return encoder.encode(password);
	}
	
}
