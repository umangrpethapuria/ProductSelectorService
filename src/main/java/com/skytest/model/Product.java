package com.skytest.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.Objects;

/**
 * Created by umangrp on 14/05/2017.
 */
public class Product implements Serializable {


    @JsonProperty
    private Long id;

    @JsonProperty
    private String name;

    @JsonProperty
    private Category category;

    @JsonProperty
    private Location location;

    public Product(long id, String name, Category category, Location location) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.location = location;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
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
        Product product = (Product) o;
        return Objects.equals(id, product.id) &&
                Objects.equals(name, product.name) &&
                category == product.category &&
                Objects.equals(location, product.location);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, category, location);
    }
}
