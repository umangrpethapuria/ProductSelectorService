package com.skytest.controller;

import com.google.gson.Gson;
import com.skytest.Application.ProductSelectorApplication;
import com.skytest.dto.ProductsDTO;
import com.skytest.model.Category;
import com.skytest.model.Location;
import com.skytest.model.Product;
import com.skytest.service.CatalogueService;
import com.skytest.service.CustomerLocationService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import javax.servlet.http.Cookie;
import java.util.HashSet;
import java.util.Set;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Created by umangrp on 14/05/2017.
 */
@RunWith(SpringRunner.class)
@ContextConfiguration(classes = {ProductSelectorApplication.class})
@WebMvcTest(SelectionController.class)
public class SelectionControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private CatalogueService catalogueService;

    @MockBean
    private CustomerLocationService customerLocationService;


    @Test
    public void testProductsEndpoint() throws Exception {

        ProductsDTO productsDTO = new ProductsDTO();
        Set<Product> products = new HashSet<>();

        products.add(new Product(1L, "Arsenal Tv", Category.SPORTS, new Location(1L, "London")));
        products.add(new Product(2L, "Liverpool Tv", Category.SPORTS, new Location(2L, "Liverpool")));

        productsDTO.setProducts(products);

        given(this.catalogueService.getProducts(1L))
                .willReturn(productsDTO);

        Gson gson = new Gson();
        String json = gson.toJson(productsDTO);

        Cookie cookie = new Cookie("locationId", "1");
        this.mvc.perform(get("/products").cookie(cookie))
                .andExpect(status().isOk()).andExpect(content().json(json));
    }

    @Test
    public void testCustomerLocation() throws Exception {

        given(this.customerLocationService.getLocationIdForCustomer(1L))
                .willReturn(1L);

        Cookie cookie = new Cookie("customerId", "1");
        this.mvc.perform(get("/customer/location").cookie(cookie))
                .andExpect(status().isOk()).andExpect(content().string("1"));
    }
}