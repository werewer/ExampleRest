package com.pasha.ExampleRest.controller;

import com.pasha.ExampleRest.entity.Address;
import com.pasha.ExampleRest.exceptions.WrongFormatException;
import com.pasha.ExampleRest.repo.AddressFakeRepository;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("addr/getaddrdata")
public class AddressRestController {

    private final AddressFakeRepository repository;

    public AddressRestController(AddressFakeRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<Address> getAllAddr() {
        return repository.findAll();
    }

    @GetMapping("{ids}")
    public List<Address> getAddrList(@PathVariable String[] ids) {
        List<Long> idsLong = new ArrayList<>(ids.length);
        for (int i = 0; i < ids.length; i++) {
            try {
                long l = Long.parseLong(ids[i]);
                idsLong.add(l);
            } catch (NumberFormatException e) {
                throw new WrongFormatException(Long.class.getSimpleName() + " in \"" + ids[i] + "\"");
            }
        }
        return repository.findByIdList(idsLong);
    }
}
