package com.codebytes.partnerportal.user.controller;

import java.security.Principal;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.client.RestTemplate;

import com.codebytes.partnerportal.common.domain.user.Customer;
import com.codebytes.partnerportal.user.domain.rest.product.GetAllProductResponse;
import com.codebytes.partnerportal.user.service.CustomerService;

@Controller
public class HomeController {
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private CustomerService customerService;
	
	@GetMapping("/")
	public String home(Principal principal, Model model) {
		
		//Customer customer = customerService.findCustomerByUsername(principal.getName());

        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        
        GetAllProductResponse getAllProductResponse = new GetAllProductResponse();

        getAllProductResponse.setUserId(1);
        getAllProductResponse.setApiKey("$2a$12$11gYnTY5.gxGGKkd2v3a1e4ExvAz5Hqw3WdUW/oNFIeJWl6BUC9Dm");


        HttpEntity<GetAllProductResponse> entity = new HttpEntity<>(getAllProductResponse, headers);
        
        //List<GetAllProductRequest> =  restTemplate.exchange("http://api-partnerportal.herokuapp.com/product/getAll", HttpMethod.POST, entity, String.class).getBody();
        
        
        ResponseEntity<GetAllProductResponse> response = restTemplate.exchange(
        "http://api-partnerportal.herokuapp.com/product/getAll",
          HttpMethod.POST,
          entity,
          new ParameterizedTypeReference<GetAllProductResponse>(){});
        GetAllProductResponse store = response.getBody();
        model.addAttribute("store", store);
		return "home"; 
	}
	
}
