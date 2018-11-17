package com.codebytes.partnerportal.common.domain.common;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.extern.java.Log;

import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.util.Set;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Log
@MappedSuperclass
public abstract class Account
{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected long accountId;

    protected String username;
    protected String password;

    @Embedded
    protected Name name;

    @Embedded
    protected Address address;

    @Embedded
    protected ContactDetails contactDetails;

    protected String accountImageLink;
    
    protected boolean enabled;

    protected String role;
    
}
