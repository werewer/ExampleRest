package com.pasha.ExampleRest.entity;

import java.io.Serializable;

public class Address implements Serializable {
    private Long id;
    private String fullAddress;

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public String getFullAddress() {
        return fullAddress;
    }
    public void setFullAddress(String fullAddress) {
        this.fullAddress = fullAddress;
    }
}
