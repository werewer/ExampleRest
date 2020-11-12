package com.pasha.ExampleRest.services;

import com.pasha.ExampleRest.entity.Address;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.*;

@Service
public class AddressClientServiceRest implements AddressService {
    private final RestTemplate restTemplate;
    private final String serverUrl;

    public AddressClientServiceRest(
            RestTemplate restTemplate,
            @Value("${application.server.url}") String serverUrl
    ) {
        this.restTemplate = restTemplate;
        this.serverUrl = serverUrl;
    }

    @Override
    public Address findAddressById(Long id) {
        if (id == null) return new Address();
        return restTemplate.getForEntity(
                serverUrl + "/addr/getaddrdata/" + id.toString(),
                Address.class
        ).getBody();
    }

    @Override
    public List<Address> findAllAddress() {
        return restTemplate.exchange(
                serverUrl + "/addr/getaddrdata",
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<Address>>() {}
        ).getBody();
    }

    @Override
    public List<Address> findAddressByIds(List<Long> ids) {
        if (ids == null || ids.isEmpty()) return Collections.emptyList();

        StringBuilder idsSb = new StringBuilder();
        Iterator<Long> iter = ids.iterator();
        while (iter.hasNext()) {
            idsSb.append(iter.next());
            if (iter.hasNext()) {
                idsSb.append(",");
            }
        }

        return restTemplate.exchange(
                serverUrl + "/addr/getaddrdata/" + idsSb.toString(),
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<Address>>() {}
        ).getBody();
    }
}
