// package com.xuegao.account.config;
//
// import com.alibaba.druid.pool.DruidDataSource;
// import io.seata.rm.datasource.DataSourceProxy;
// import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
// import org.springframework.boot.context.properties.ConfigurationProperties;
// import org.springframework.context.annotation.Bean;
// import org.springframework.context.annotation.Configuration;
// import org.springframework.jdbc.core.JdbcTemplate;
//
// import javax.sql.DataSource;
//
// /**
//  * <br/> @ClassName：DataSourceConfig
//  * <br/> @Description：
//  * <br/> @date：2021/9/3 19:43
//  */
// @Configuration
// public class DataSourceConfig {
//
//     @Bean
//     @ConfigurationProperties(prefix = "spring.datasource")
//     public DataSource dataSource() {
//         return new DruidDataSource();
//     }

    // @Primary
    // @Bean("dataSourceProxy")
    // public DataSourceProxy dataSourceProxy(DataSource dataSource) {
        //AT 代理 二选一
        // return new DataSourceProxy(dataSource);
        //XA 代理
        // return new DataSourceProxyXA(dataSource);
    // }

//     @Bean("jdbcTemplate")
//     @ConditionalOnBean(DataSourceProxy.class)
//     public JdbcTemplate jdbcTemplate(DataSourceProxy dataSourceProxy) {
//         return new JdbcTemplate(dataSourceProxy);
//     }
// }