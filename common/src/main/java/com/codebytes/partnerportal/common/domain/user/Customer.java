package com.codebytes.partnerportal.common.domain.user;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

import com.codebytes.partnerportal.common.validator.ValidPassword;

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
	
	@NotBlank
    protected String username;
	
	@ValidPassword
    protected String password;

	@NotBlank
    protected String fullname;

	@NotBlank
    protected String address;

    @Email
    @NotBlank
    protected String email;

    protected String accountImageLink;
    
    protected boolean enabled;

    protected String role;
    
}
