package com.skytest.service;

import com.skytest.model.Customer;
import com.skytest.model.Location;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by umangrp on 14/05/2017.
 */
public class CustomerLocationServiceImpl implements CustomerLocationService {

    //TODO Replace this with data stored in database
    private static List<Customer> customers = null;
    static{
        customers = new ArrayList<>();
        customers.add(new Customer(1L, new Location(1L, "London")));
        customers.add(new Customer(2L, new Location(2L, "Liverpool")));
        customers.add(new Customer(3L, null));
    }

    @Override
    public Long getLocationIdForCustomer(Long customerId) {
        for (Customer customer: customers) {
            if(customerId.equals(customer.getId())){

                Location location = customer.getLocation();
                return location != null ? location.getId() : -1L;
            }
        }

        return null;
    }
}
