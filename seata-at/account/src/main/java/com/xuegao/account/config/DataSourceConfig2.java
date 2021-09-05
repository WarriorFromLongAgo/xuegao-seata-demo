// package com.xuegao.account.config;
//
// import com.alibaba.druid.pool.DruidDataSource;
// import io.seata.rm.datasource.DataSourceProxy;
// import org.slf4j.Logger;
// import org.slf4j.LoggerFactory;
// import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
// import org.springframework.boot.context.properties.ConfigurationProperties;
// import org.springframework.context.annotation.Bean;
// import org.springframework.context.annotation.Configuration;
// import org.springframework.context.annotation.Primary;
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
// public class DataSourceConfig2 {
//     private static final Logger log = LoggerFactory.getLogger(DataSourceConfig2.class);
//
//     @Bean
//     @ConfigurationProperties(prefix = "spring.datasource")
//     public DataSource dataSource() {
//         return new DruidDataSource();
//     }
//
//     @Primary
//     @Bean("dataSourceProxy")
//     @ConditionalOnBean(DataSource.class)
//     public DataSourceProxy dataSourceProxy(DataSource dataSource) {
//         return new DataSourceProxy(dataSource);
//     }
//
//     @Bean("jdbcTemplate")
//     @ConditionalOnBean(DataSourceProxy.class)
//     public JdbcTemplate jdbcTemplate(DataSourceProxy dataSourceProxy) {
//         log.info("DataSourceProxy = {}", dataSourceProxy);
//         return new JdbcTemplate(dataSourceProxy);
//     }
// }