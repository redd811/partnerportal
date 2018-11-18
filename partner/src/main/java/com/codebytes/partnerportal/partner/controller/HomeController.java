package com.codebytes.partnerportal.partner.controller;

import com.codebytes.partnerportal.common.domain.partner.PartnerBrand;
import com.codebytes.partnerportal.common.domain.rest.Product;
import com.codebytes.partnerportal.common.domain.rest.product.CreateProductRequest;
import com.codebytes.partnerportal.common.domain.rest.product.GetAllProductRequest;
import com.codebytes.partnerportal.common.domain.rest.product.GetAllProductResponse;
import com.codebytes.partnerportal.partner.service.SellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.security.Principal;
import java.util.Arrays;
import java.util.List;

@Controller
public class HomeController {
    @Autowired
    private SellerService sellerService;

    @Autowired
    private RestTemplate restTemplate;

    /*
    public String getProductList(){
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<Product> entity = new HttpEntity<Product>(product,headers);

        return restTemplate.exchange("192.168.10.83:8080/product/getAll", HttpMethod.POST, entity, String.class).getBody();
    }
    */

    @GetMapping("/dashboard")
    public String dashboard (Model model, Principal principal, GetAllProductRequest getAllProductRequest) {
        PartnerBrand partnerBrand = sellerService.getInformationOfLoggedInUser(principal.getName());
        PartnerBrand getUserIdOfLoggedInUser = sellerService.getInformationOfLoggedInUser(principal.getName());




        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));

        getAllProductRequest.setUserId(getUserIdOfLoggedInUser.getAccountId());
        getAllProductRequest.setApiKey("$2a$12$11gYnTY5.gxGGKkd2v3a1e4ExvAz5Hqw3WdUW/oNFIeJWl6BUC9Dm");

        HttpEntity<GetAllProductRequest> entity = new HttpEntity<>(getAllProductRequest, headers);

        ResponseEntity<GetAllProductResponse> response = restTemplate.exchange(
                "http://api-partnerportal.herokuapp.com/product/getAll",
                HttpMethod.POST,
                entity,
                new ParameterizedTypeReference<GetAllProductResponse>(){});
        GetAllProductResponse getAllProductResponse = response.getBody();

        System.out.println(getAllProductResponse);

        //HttpEntity<GetAllProductRequest> entity = new HttpEntity<>(getAllProductRequest, headers);

        model.addAttribute("seller", partnerBrand);
        model.addAttribute("product", new CreateProductRequest());
        model.addAttribute("products",getAllProductResponse);

        return "dashboard";
    }

    @GetMapping("/")
    public String login (Principal principal) { return principal == null ? "login" : "redirect:/dashboard"; }

    @GetMapping("logout")
    public String logout (HttpServletRequest request, HttpServletResponse response) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null){
            new SecurityContextLogoutHandler().logout(request, response, auth);
        }
        return "redirect:/?logout";
    }
}
