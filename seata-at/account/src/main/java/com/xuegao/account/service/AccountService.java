package com.xuegao.account.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class AccountService {
    private static final Logger log = LoggerFactory.getLogger(AccountService.class);

    @Autowired
    @Lazy
    private JdbcTemplate jdbcTemplate;

    public void reduce(String userId, int money) {
        log.info("AccountService reduce {}, {}", userId, money);
        jdbcTemplate.update("update t_account set money = money - ? where user_id = ?", new Object[] {money, userId});
    }
}
