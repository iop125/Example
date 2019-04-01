package com.example.springboot.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement  //开启事物
@EnableCaching                //开启redis
public class SpringbootApplication {

    public static void main(String[] arg) {
        SpringApplication.run(SpringbootApplication.class, arg);
    }

}
