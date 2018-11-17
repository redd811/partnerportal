package com.codebytes.partnerportal.user.controller;

import java.security.Principal;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SignInController {
	@GetMapping("/sign-in")
	public String signIn(Principal principal) {
		return principal == null ? "sign-in" : "redirect:/";
	}
}
