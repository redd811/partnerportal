package com.codebytes.partnerportal.user.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codebytes.partnerportal.common.domain.common.Account;

@Repository
public interface AccountRepository extends CrudRepository<Account, Long>{
	//boolean existsByUsername(String username);
	//boolean existsByEmail(String email);
}
