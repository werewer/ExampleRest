package com.pasha.ExampleRest;

import com.pasha.ExampleRest.entities.Address;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class ExampleRestApplication {

    private static final Logger log = LoggerFactory.getLogger(ExampleRestApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(ExampleRestApplication.class, args);
    }

    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
        return builder.build();
    }

    @Bean
    public CommandLineRunner run(RestTemplate restTemplate) throws Exception {
        return new CommandLineRunner() {
            @Override
            public void run(String... args) throws Exception {
                Address address = restTemplate.getForObject(" http://{some.url}/addr/getaddrdata/{addr_id}",
                        Address.class);
                log.info(address.toString());
            }
        };
    }
}
