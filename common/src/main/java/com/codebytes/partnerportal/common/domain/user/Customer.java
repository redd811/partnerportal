package com.codebytes.partnerportal.common.domain.user;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Customer
{
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected long accountId;

    protected String username;
    protected String password;

    protected String fullname;

    protected String address;

    protected String email;

    protected String accountImageLink;
    
    protected boolean enabled;

    protected String role;
    
}
