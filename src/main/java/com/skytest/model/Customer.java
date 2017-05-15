package com.skytest.model;

import java.util.Objects;

/**
 * Created by umangrp on 14/05/2017.
 */
public class Customer {

    private Long Id;

    private Location location;

    public Customer(Long id, Location location) {
        this.location = location;
        Id = id;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        return Objects.equals(Id, customer.Id) &&
                Objects.equals(location, customer.location);
    }

    @Override
    public int hashCode() {
        return Objects.hash(Id, location);
    }
}
