package com.xuegao.business.fallback;

import com.xuegao.business.feign.StorageFeignClient;
import feign.hystrix.FallbackFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

/**
 * <br/> @PackageName：com.xuegao.business.fallback
 * <br/> @ClassName：StorageFeignFallback
 * <br/> @Description：
 * <br/> @author：xuegao
 * <br/> @date：2021/9/6 21:16
 */
@Component
public class StorageFeignFallback implements FallbackFactory<StorageFeignClient> {
    private static final Logger log = LoggerFactory.getLogger(StorageFeignFallback.class);

    @Override
    public StorageFeignClient create(Throwable throwable) {
        String msg = throwable == null ? "" : throwable.getMessage();

        /**
         * 这里就能看到account的debit方法被调用里面抛出了除以0的异常
         *
         * 2021-03-19 10:53:12.016 ERROR[hystrix-app-account-2]com.sid.rpc.fallback.AccountServiceFallback.create:39 -AccountServiceFallback 中有方法降级，throwable.getMessage():status 500 reading AccountFeignClient#debit(String,Double); content:
         * {"timestamp":"2021-03-19T02:53:12.008+0000","status":500,"error":"Internal Server Error","message":"/ by zero","path":"/account/debit"}
         * */
        if (!StringUtils.isEmpty(msg)) {
            log.error("AccountServiceFallback 中有方法降级，throwable.getMessage():{}", msg);
        }
        return new StorageFeignClient() {
            @Override
            public void deduct(String commodityCode, Integer count) {

            }
        };
    }
}