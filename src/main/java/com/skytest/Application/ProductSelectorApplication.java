package com.skytest.Application;

import com.skytest.service.CatalogueService;
import com.skytest.service.CatalogueServiceImpl;
import com.skytest.service.CustomerLocationService;
import com.skytest.service.CustomerLocationServiceImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

/**
 * Created by umangrp on 14/05/2017.
 */
@SpringBootApplication
@ComponentScan(basePackages = "com.skytest")
public class ProductSelectorApplication {
    public static void main(String[] args){
        SpringApplication.run(ProductSelectorApplication.class);
    }

    @Bean
    CustomerLocationService customerLocationService() {
        return new CustomerLocationServiceImpl();
    }

    @Bean
    CatalogueService catalogueService() {
        return new CatalogueServiceImpl();
    }
}
