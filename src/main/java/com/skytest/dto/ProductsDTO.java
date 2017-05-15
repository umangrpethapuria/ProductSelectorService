package com.skytest.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.skytest.model.Product;

import java.io.Serializable;
import java.util.Set;

/**
 * Created by umangrp on 14/05/2017.
 */
public class ProductsDTO implements Serializable{

    @JsonProperty
    private Set<Product> products;

    public ProductsDTO() {
    }

    public ProductsDTO(Set<Product> products) {
        this.products = products;
    }


    public Set<Product> getProducts() {
        return products;
    }

    public void setProducts(Set<Product> products) {
        this.products = products;
    }
}
