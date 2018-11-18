package com.codebytes.partnerportal.common.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Embeddable;
import javax.persistence.Embedded;

@Setter
@Getter
@EqualsAndHashCode
@Embeddable
public class Discount {
    private int discountValue;

    @Embedded
    private Credit requiredCredits;
}
