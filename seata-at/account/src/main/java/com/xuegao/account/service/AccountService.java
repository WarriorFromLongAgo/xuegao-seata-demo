package com.xuegao.account.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class AccountService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void reduce(String userId, int money) {
        jdbcTemplate.update("update t_account set money = money - ? where user_id = ?", new Object[] {money, userId});
    }
}
