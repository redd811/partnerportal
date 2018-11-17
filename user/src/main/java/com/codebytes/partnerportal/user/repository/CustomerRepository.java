package com.codebytes.partnerportal.user.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codebytes.partnerportal.common.domain.user.Customer;

@Repository
public interface CustomerRepository extends CrudRepository<Customer, Long>{
	boolean existsByUsername(String username);
	boolean existsByEmail(String email);
	Customer findCustomerByUsername(String username);
}
