package com.xuegao.order.service;

import com.xuegao.order.feign.UserFeignClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

/**
 * @author jimin.jm@alibaba-inc.com
 * @date 2019/06/14
 */
@Service
public class OrderService {
    private static final Logger log = LoggerFactory.getLogger(OrderService.class);

    @Autowired
    private UserFeignClient userFeignClient;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void create(String userId, String commodityCode, Integer count) {

        int orderMoney = count * 100;
        log.info("OrderService create {}, {}, {}", userId, commodityCode, count);
        jdbcTemplate.update("insert t_order(user_id,commodity_code,`count`,money) " +
                "values(?,?,?,?)", new Object[]{userId, commodityCode, count, orderMoney});
        userFeignClient.reduce(userId, orderMoney);
    }
}
