package com.pasha.ExampleRest.services;

import com.pasha.ExampleRest.entities.Address;

import java.util.Collection;
import java.util.List;

public interface AddressService {
    Collection<Address> findAllAddress();
    Address findAddressById(Long id);
    Collection<Address> findAddressByIds(List<Long> ids);
}
