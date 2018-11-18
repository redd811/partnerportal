package com.codebytes.partnerportal.user.controller;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.client.RestTemplate;

import com.codebytes.partnerportal.user.domain.rest.product.GetAllProductResponse;
import com.codebytes.partnerportal.user.domain.rest.product.GetProductByIdRequest;
import com.codebytes.partnerportal.user.domain.rest.product.GetProductByIdResponse;

@Controller
public class ProductController {
	
	@Autowired
	private RestTemplate restTemplate;
	
	@GetMapping("/product/{id}")
	public String product(@PathVariable long id, Model model) {
		HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        
        GetProductByIdRequest getProductByRequest = new GetProductByIdRequest();
        
        getProductByRequest.setProductId(id);
        getProductByRequest.setUserId(1);
        getProductByRequest.setApiKey("$2a$12$11gYnTY5.gxGGKkd2v3a1e4ExvAz5Hqw3WdUW/oNFIeJWl6BUC9Dm");


        HttpEntity<GetProductByIdRequest> entity = new HttpEntity<>(getProductByRequest, headers);
        
        //List<GetAllProductRequest> =  restTemplate.exchange("http://api-partnerportal.herokuapp.com/product/getAll", HttpMethod.POST, entity, String.class).getBody();
        
        
        ResponseEntity<GetProductByIdResponse> response = restTemplate.exchange(
        "http://api-partnerportal.herokuapp.com/product/getProductById",
          HttpMethod.POST,
          entity,
          new ParameterizedTypeReference<GetProductByIdResponse>(){});
        GetProductByIdResponse product = response.getBody();
        model.addAttribute("product", product);
        
		return "product"; }
}
