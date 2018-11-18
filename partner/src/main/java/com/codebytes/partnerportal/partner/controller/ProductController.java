package com.codebytes.partnerportal.partner.controller;

import com.codebytes.partnerportal.common.domain.partner.PartnerBrand;
import com.codebytes.partnerportal.common.domain.rest.product.CreateProductRequest;
import com.codebytes.partnerportal.common.domain.rest.product.GetAllProductRequest;
import com.codebytes.partnerportal.partner.service.SellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import javax.validation.Valid;
import java.security.Principal;
import java.util.Arrays;
import java.util.List;

@Controller
public class ProductController {
    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private SellerService sellerService;

    @PostMapping("/product/create")
    public String createProduct(@ModelAttribute("product") CreateProductRequest createProductRequest, BindingResult result, Model model,  Principal principal){
        if(result.hasErrors())
            return "dashboard";

        PartnerBrand getUserIdOfLoggedInUser = sellerService.getInformationOfLoggedInUser(principal.getName());

        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));

        createProductRequest.setUserId(getUserIdOfLoggedInUser.getAccountId());
        createProductRequest.setApiKey("$2a$12$11gYnTY5.gxGGKkd2v3a1e4ExvAz5Hqw3WdUW/oNFIeJWl6BUC9Dm");

        HttpEntity<CreateProductRequest> entity = new HttpEntity<>(createProductRequest, headers);

        restTemplate.exchange("http://api-partnerportal.herokuapp.com/product/create", HttpMethod.POST, entity, String.class).getBody();

        model.addAttribute("message", restTemplate.exchange("http://api-partnerportal.herokuapp.com/product/create", HttpMethod.POST, entity, String.class).getBody());
        return "redirect:/dashboard?success_product";
    }
}
