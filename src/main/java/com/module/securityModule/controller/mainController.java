package com.module.securityModule.controller;

import java.security.Principal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author tunyaa
 */
@Controller
@RequestMapping
public class mainController {

    @GetMapping("/")
    public String getMain() {
        return "main";
    }
    
@GetMapping("/me")
    public String getMain(Principal principal, Model model) {
        model.addAttribute("principal", principal.getName());
        return "me";
    }
    
    @GetMapping("/user")
    public String getUser() {
        return "user";
    }

    @GetMapping("/admin")
    public String getAdmin() {
        return "admin";
    }

    @GetMapping("/organizer")
    public String getOrganier() {
        return "/organizer";
    }

    @GetMapping("/login")
    public String getLogin() {
        return "login";
    }
}
