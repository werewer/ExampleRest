package com.pasha.ExampleRest.controller;

import com.pasha.ExampleRest.entities.Address;
import com.pasha.ExampleRest.services.AddressDefaultSourceService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("addr/getaddrdata")
public class AddressRestController {

    @GetMapping("{addr_id}")
    public Address getAddr(Long addrId) {
        return getTestAddressById(addrId);
    }

    public List<Address> getTestAddresses() {
        return TEST_ADDRESSES;
    }

    public Address getTestAddressById(Long addrId) {
        if (addrId == null) return null;
        return TEST_ADDRESSES.stream().filter(addr -> addrId.equals(addr.getId())).findFirst().orElse(null);
    }

    private static final List<Address> TEST_ADDRESSES = new ArrayList<>(3) {{
        add(new Address() {{
            setId(1L);
            setFullAddress("Россия, Москва, 1-й Красногвардейский проезд, д. 15");
        }});

        add(new Address(){{
            setId(2L);
            setFullAddress("Россия, Москва, ул.Пушкина, дом Колотушкина");
        }});

        add(new Address(){{
            setId(3L);
            setFullAddress("Россия, Томск, ул.Ленина, д.4");
        }});
    }};
}
