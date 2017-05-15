package com.skytest.service;

import com.skytest.dto.ProductsDTO;
import com.skytest.model.Category;
import com.skytest.model.Location;
import com.skytest.model.Product;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by umangrp on 14/05/2017.
 */
public class CatalogueServiceImpl implements CatalogueService{

    //TODO Replace this with data stored in database
    private static List<Product> products = null;
    static{
        products = new ArrayList<>();
        products.add(new Product(1L, "Arsenal Tv", Category.SPORTS, new Location(1L, "London")));
        products.add(new Product(2L, "Chelsea Tv", Category.SPORTS, new Location(1L, "London")));
        products.add(new Product(3L, "Liverpool Tv", Category.SPORTS, new Location(2L, "Liverpool")));
        products.add(new Product(4L, "Sky News", Category.NEWS, null));
        products.add(new Product(5L, "Sky Sports News", Category.NEWS, null));
    }

    @Override
    public ProductsDTO getProducts(Long locationId) {
        Set<Product> availableProducts = new HashSet<>();

        for (Product product: products) {
            if(product.getLocation() == null || product.getLocation().getId().equals(locationId)){
                availableProducts.add(product);
            }
        }

        return new ProductsDTO(availableProducts);
    }
}
