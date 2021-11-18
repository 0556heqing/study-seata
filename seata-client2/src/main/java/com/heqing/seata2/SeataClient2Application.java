package com.heqing.seata2;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author heqing
 * @date 2021/7/14 10:40
 */
@MapperScan("com.heqing.seata2")
@EnableTransactionManagement
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
public class SeataClient2Application {

    public static void main(String[] args) {
        new SpringApplication(SeataClient2Application.class).run(args);
    }

}
