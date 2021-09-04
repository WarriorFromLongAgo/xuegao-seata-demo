package com.xuegao.business.controller;

import com.xuegao.business.service.BusinessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author jimin.jm@alibaba-inc.com
 * @date 2019/06/14
 */

@RestController
public class BusinessController {

    @Autowired
    private BusinessService businessService;

    /**
     * <br/> @Title:
     * <br/> @Description: 购买下单，模拟全局事务提交
     * <br/> @MethodName: purchaseCommit
     * <br/>
     * <br/> @return: java.lang.String
     * <br/> @author: xuegao
     * <br/> @date: 2021/9/4 17:15
     */
    @RequestMapping(value = "/purchase/commit", produces = "application/json")
    public String purchaseCommit() {
        try {
            businessService.purchase("U100000", "C100000", 30);
        } catch (Exception exx) {
            return exx.getMessage();
        }
        return "全局事务提交";
    }

    /**
     * <br/> @Title:
     * <br/> @Description: 购买下单，模拟全局事务回滚
     * <br/> @Description: 账户或库存不足
     * <br/> @MethodName: purchaseRollback
     * <br/> @return: java.lang.String
     * <br/> @author: xuegao
     * <br/> @date: 2021/9/4 17:14
     */
    @RequestMapping("/purchase/rollback")
    public String purchaseRollback() {
        try {
            businessService.purchase("U100000", "C100000", 99999);
        } catch (Exception exx) {
            return exx.getMessage();
        }
        return "全局事务提交";
    }
}
