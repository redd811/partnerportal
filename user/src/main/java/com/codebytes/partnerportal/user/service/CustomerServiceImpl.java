package com.codebytes.partnerportal.user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.codebytes.partnerportal.common.domain.user.Customer;
import com.codebytes.partnerportal.user.repository.CustomerRepository;

@Service
public class CustomerServiceImpl implements CustomerService {
	
	@Autowired
	private CustomerRepository customerRepository;
	
	@Autowired
	private PasswordEncoder encoder;

	@Override
	public boolean isUsernameExist(String username) {
		return customerRepository.existsByUsername(username);
	}

	@Override
	public boolean isEmailExist(String email) {
		return customerRepository.existsByEmail(email);
	}

	@Override
	public boolean isPasswordMatch(String password, String confirmPassword) {
		return password.equals(confirmPassword);
	}

	@Override
	public Customer saveOrUpdateUser(Customer account) {
		return customerRepository.save(account);
	}

	@Override
	public String hashPassword(String password) {
		return encoder.encode(password);
	}
	
	
	
}
