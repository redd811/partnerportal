package com.codebytes.partnerportal.partner.controller;

import com.codebytes.partnerportal.common.domain.partner.PartnerBrand;
import com.codebytes.partnerportal.partner.service.SellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.security.Principal;
import java.util.Arrays;

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
    public String dashboard (Model model, Principal principal) {
        PartnerBrand partnerBrand = sellerService.getInformationOfLoggedInUser(principal.getName());
        model.addAttribute("seller", partnerBrand);

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
