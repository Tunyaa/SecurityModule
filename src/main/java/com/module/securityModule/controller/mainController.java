package com.module.securityModule.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author tunyaa
 */
@Controller
@RequestMapping("/")
public class mainController {

    @GetMapping
    public String getMain() {
        return "main";
    }
}
