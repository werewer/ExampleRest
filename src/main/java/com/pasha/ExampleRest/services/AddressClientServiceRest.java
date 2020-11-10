package com.pasha.ExampleRest.services;

import com.pasha.ExampleRest.entities.Address;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class AddressClientServiceRest implements AddressService {
    private final RestTemplate restTemplate;
    private final String serverUrl;

    public AddressClientServiceRest(RestTemplate restTemplate, @Value("${application.server.url}") String serverUrl) {
        this.restTemplate = restTemplate;
        this.serverUrl = serverUrl;
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

}
