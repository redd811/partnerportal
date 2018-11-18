package com.codebytes.partnerportal.partner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan(basePackages="com.codebytes.partnerportal.common")
public class PartnerPortalAdminApplication {
	public static void main(String[] args) {
		SpringApplication.run(PartnerPortalAdminApplication.class, args);
	}
}
