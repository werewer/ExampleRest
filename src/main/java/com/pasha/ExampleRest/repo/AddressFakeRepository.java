package com.pasha.ExampleRest.repo;

import com.pasha.ExampleRest.entity.Address;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Component
public class AddressFakeRepository {

    public List<Address> findAll() {
        return TEST_ADDRESSES;
    }

    public Address findById(Long addrId) {
        if (addrId == null) return new Address();
        return TEST_ADDRESSES.stream().filter(addr -> addrId.equals(addr.getId())).findFirst().orElse(new Address());
    }

    public List<Address> findByIdList(List<Long> addrId) {
        if (addrId == null || addrId.isEmpty()) return Collections.emptyList();
        List<Address> found = new ArrayList<>();
        addrId.forEach(id -> TEST_ADDRESSES.stream().filter(addr -> id.equals(addr.getId())).forEach(found::add));
        return found;
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
