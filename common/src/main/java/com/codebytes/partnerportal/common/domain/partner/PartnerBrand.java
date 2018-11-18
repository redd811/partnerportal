package com.codebytes.partnerportal.common.domain.partner;

import com.codebytes.partnerportal.validator.ValidPassword;
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
import javax.validation.constraints.NotEmpty;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class PartnerBrand
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected long accountId;

    @NotEmpty
    protected String username;

    @ValidPassword
    protected String password;

    @NotEmpty
    protected String fullname;

    @NotEmpty
    protected String address;

    @Email
    @NotEmpty
    protected String email;

    protected String accountImageLink;

    protected boolean enabled;

    protected String role;
}
