package com.pasha.ExampleRest.services;

import com.pasha.ExampleRest.entity.Address;
import com.pasha.ExampleRest.repo.AddressFakeRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AddressServiceDb {

    private final AddressFakeRepository repository;

    public AddressServiceDb(AddressFakeRepository repository) {
        this.repository = repository;
    }

    public List<Address> findAllAddress() {
        List<Address> list = new ArrayList<>();
        repository.findAll().forEach(list::add);
        return list;
    }

    public Address findAddressById(Long id) {
        return repository.findById(id);
    }
}
