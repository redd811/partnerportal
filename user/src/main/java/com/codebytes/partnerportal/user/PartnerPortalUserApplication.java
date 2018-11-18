package com.codebytes.partnerportal.user;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;

@SpringBootApplication
@EntityScan(basePackages="com.codebytes.partnerportal.common")
public class PartnerPortalUserApplication
{

	public static void main(String[] args) {
		SpringApplication.run(PartnerPortalUserApplication.class, args);
	}
}
