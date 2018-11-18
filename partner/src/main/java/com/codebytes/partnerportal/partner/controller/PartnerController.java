package com.codebytes.partnerportal.partner.controller;

import com.codebytes.partnerportal.common.domain.partner.PartnerBrand;
import com.codebytes.partnerportal.partner.service.SellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import java.security.Principal;

@Controller
public class PartnerController {
    @Autowired
    private SellerService sellerService;

    @GetMapping("/seller-sign-up")
    public String signUp(Model model) {
        model.addAttribute("seller", new PartnerBrand());
        return "register";
    }

    @PostMapping("/seller-sign-up")
    public String validateUser(@ModelAttribute("seller") @Valid PartnerBrand partnerBrand, BindingResult result, Model model, @RequestParam("confirmPassword") String confirmPassword) {

        boolean isUsernameExist = sellerService.isUsernameExist(partnerBrand.getUsername());
        boolean isEmailExist = sellerService.isEmailExist(partnerBrand.getEmail());
        boolean isPasswordMatch = sellerService.isPasswordMatch(partnerBrand.getPassword(), confirmPassword);

        if(isUsernameExist)
            result.rejectValue("username", "error.username", "Username already exist");
        if(isEmailExist)
            result.rejectValue("email", "error.email", "Email already exist");
        if(!isPasswordMatch)
            model.addAttribute("confirmPassword", "Password not match");

        if(result.hasErrors())
            return "register";

        partnerBrand.setPassword(sellerService.hashPassword(partnerBrand.getPassword()));
        partnerBrand.setRole("SELLER");
        partnerBrand.setEnabled(true);
        sellerService.saveOrUpdateUser(partnerBrand);

        return "redirect:/?success";
    }

    @PostMapping("/update-seller")
    public String updateUser(@ModelAttribute("seller") PartnerBrand partnerBrand, BindingResult result, Model model, Principal principal){
        PartnerBrand detectIfExisting = sellerService.getInformationOfLoggedInUser(principal.getName());

        if(detectIfExisting != null){
            detectIfExisting.setFullname(partnerBrand.getFullname());
            detectIfExisting.setAddress(partnerBrand.getAddress());
            detectIfExisting.setEmail(partnerBrand.getEmail());

            sellerService.saveOrUpdateUser(detectIfExisting);

            if(detectIfExisting.getUsername().compareTo(partnerBrand.getUsername()) != 0){
                return "redirect:/logout";
            }
        }

        return "redirect:/dashboard?success_update";
    }
}
