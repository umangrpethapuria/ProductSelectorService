package com.skytest.service;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;

/**
 * Created by umangrp on 14/05/2017.
 */
public class CustomerLocationServiceImplTest {
    @Test
    public void testGetLocationIdForCustomerHappyPath() throws Exception {

        Long customerId = 1L;
        CustomerLocationService customerLocationService = new CustomerLocationServiceImpl();
        Long locationId = customerLocationService.getLocationIdForCustomer(customerId);

        assertThat("Customer location is London", locationId, is(1L));
    }

    @Test
    public void testGetLocationIdForCustomerReturnsNullIfLocationNotFound() throws Exception {

        Long customerId = 3L;
        CustomerLocationService customerLocationService = new CustomerLocationServiceImpl();
        Long locationId = customerLocationService.getLocationIdForCustomer(customerId);

        assertThat("Customer location is not set", locationId, is(-1L));
    }

    @Test
    public void testGetLocationIdForCustomerReturnsNullIfCustomerNotFound() throws Exception {

        Long customerId = 4L;
        CustomerLocationService customerLocationService = new CustomerLocationServiceImpl();
        Long locationId = customerLocationService.getLocationIdForCustomer(customerId);

        assertNull(locationId);
    }
}