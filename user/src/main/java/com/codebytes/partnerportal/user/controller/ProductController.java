package com.codebytes.partnerportal.user.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class ProductController {
	@GetMapping("/product/{id}")
	public String product(@PathVariable long id) {
		System.out.println(id);
		return "product"; }
}
