package com.pasha.ExampleRest.services;

import com.pasha.ExampleRest.entities.Address;

import java.util.List;

public interface AddressService {
    List<Address> findAllAddress();
}
