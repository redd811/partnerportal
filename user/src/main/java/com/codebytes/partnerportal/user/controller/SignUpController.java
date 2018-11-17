package com.codebytes.partnerportal.user.controller;

import java.util.HashSet;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.codebytes.partnerportal.common.domain.common.Account;
import com.codebytes.partnerportal.common.domain.user.Customer;
import com.codebytes.partnerportal.user.service.AccountService;

@Controller
public class SignUpController {
	
	@Autowired
	private AccountService accountService;
	
	@GetMapping("/sign-up")
	public String signUp(Model model) {
		model.addAttribute("user", new Customer());
		return "sign-up";
	}
	
	@PostMapping("/sign-up")
	public String validateUser(@ModelAttribute("user") @Valid Account account,
			   BindingResult result, Model model, @RequestParam("confirmPassword") String confirmPassword) {
		
		boolean isUsernameExist = accountService.isUsernameExist(account.getUsername());
		boolean isEmailExist = accountService.isEmailExist(account.getContactDetails().getEmailAddress());
		boolean isPasswordMatch = accountService.isPasswordMatch(account.getPassword(), confirmPassword);
		
		if(isUsernameExist)
			result.rejectValue("username", "error.username", "Username already exist");
		if(isEmailExist)
			result.rejectValue("email", "error.email", "Email already exist");
		if(!isPasswordMatch)
			model.addAttribute("confirmPassword", "Password not match");
		
		if(result.hasErrors())
			return "sign-up";
		
		
		account.setPassword(accountService.hashPassword(account.getPassword()));
		account.setRole("BUYER");;
		account.setEnabled(true);
		accountService.saveOrUpdateUser(account);
		
		return "redirect:/sign-in?success";
	}
}
