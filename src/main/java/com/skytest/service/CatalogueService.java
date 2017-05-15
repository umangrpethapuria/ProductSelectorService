package com.skytest.service;

import com.skytest.dto.ProductsDTO;

/**
 * Created by umangrp on 14/05/2017.
 */
public interface CatalogueService {
    ProductsDTO getProducts(Long locationId);
}
