package com.codebytes.partnerportal.user.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.codebytes.partnerportal.user.service.CustomerService;

@Controller
public class CheckoutController {
	
	@Autowired
	private CustomerService customerService;
	
	@GetMapping("/checkout")
	public String checkout(Model model, Principal principal) {
		model.addAttribute("customer", customerService.findCustomerByUsername(principal.getName()));
		return "checkout"; 
	}
}
