package com.pasha.ExampleRest.controller;

import com.pasha.ExampleRest.entities.Address;
import com.pasha.ExampleRest.repo.AddressFakeRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("addr/getaddrdata")
public class AddressRestController {

    private final AddressFakeRepository repository;

    public AddressRestController(AddressFakeRepository repository) {
        this.repository = repository;
    }

    @GetMapping("{addr_id}")
    public Address getAddr(@PathVariable("addr_id") Long addrId) {
        return repository.findById(addrId);
    }
    @GetMapping
    public List<Address> getAllAddr() {
        return repository.findAll();
    }

}
