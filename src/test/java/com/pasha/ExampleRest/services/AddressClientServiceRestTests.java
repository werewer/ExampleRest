package com.pasha.ExampleRest.services;

import com.pasha.ExampleRest.entity.Address;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class AddressClientServiceRestTests {

    @Autowired
    private AddressClientServiceRest addressClientServiceRest;

    @Test
    void testFindAddressAll() {
        List<Address> address = addressClientServiceRest.findAllAddress();
        checkAddresses(address);
    }

    @Test
    void testFindAddressByIds() {
        List<Address> address = addressClientServiceRest.findAddressByIds(new ArrayList<>() {{
            add(1l);
            add(2l);
            add(3l);
        }});
        checkAddresses(address);
    }

    private void checkAddresses(List<Address> address) {
        Assert.notEmpty(address, "not empty");

        Assert.isTrue(address.get(0).getId().equals(1l), "1 id get");
        Assert.isTrue(address.get(0).getFullAddress().equals("Россия, Москва, 1-й Красногвардейский проезд, д. 15"), "1 addr get");
        Assert.isTrue(address.get(1).getId().equals(2l), "2 id get");
        Assert.isTrue(address.get(1).getFullAddress().equals("Россия, Москва, ул.Пушкина, дом Колотушкина"), "2 addr get");
        Assert.isTrue(address.get(2).getId().equals(3l), "3 id get");
        Assert.isTrue(address.get(2).getFullAddress().equals("Россия, Томск, ул.Ленина, д.4"), "3 addr get");
    }

}
