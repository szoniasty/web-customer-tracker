package com.darekbojanek.springdemo.controller;

import com.darekbojanek.com.darekbojanek.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AccountController {
    @Autowired
    private AccountService accountService;

    @GetMapping("/account")
    public String addAccount() {
        accountService.addAccount();
        return "account";
    }

}
