package com.xuegao.account.controller;

import com.xuegao.account.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccountController {

    @Autowired
    private AccountService accountService;

    @RequestMapping(value = "/reduce", produces = "application/json")
    public Boolean debit(String userId, int money) {
        accountService.reduce(userId, money);
        return true;
    }
}
