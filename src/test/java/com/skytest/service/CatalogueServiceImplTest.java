package com.skytest.service;

import com.skytest.dto.ProductsDTO;
import com.skytest.model.Product;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Created by umangrp on 14/05/2017.
 */
public class CatalogueServiceImplTest {
    @Test
    public void testGetProductsHappyPath() throws Exception {

        ProductsDTO productsDTO = new CatalogueServiceImpl().getProducts(1L);

        boolean containsLocationIndependentProducts = false;
        boolean containsLocationDependentProducts = false;
        for (Product product: productsDTO.getProducts()) {
            if(product.getLocation()==null){
                containsLocationIndependentProducts = true;
            }else {
                containsLocationDependentProducts = product.getLocation().getId().equals(1L);
            }
        }

        assertThat("Contains location independent products", containsLocationIndependentProducts, is(true));
        assertThat("Contains matching location dependent products", containsLocationDependentProducts, is(true));
    }

}