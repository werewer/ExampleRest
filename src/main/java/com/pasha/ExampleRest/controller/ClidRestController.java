package com.pasha.ExampleRest.controller;

import com.pasha.ExampleRest.exceptions.NotFountException;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("addr/getaddrdata")
public class ClidRestController {

    @GetMapping
    public List<Map<String, String>> list() {
        return messages;
    }

    @GetMapping("{addr_id}")
    public Map<String, String> getOne(@PathVariable("addr_id") String addrId) {
        return getMessage(addrId);
    }

    @PostMapping
    public Map<String, String> create(@RequestBody Map<String, String> message) {
        message.put("id", String.valueOf(counter++));
        messages.add(message);
        return message;
    }

    @PutMapping("{id}")
    public Map<String, String> update(@PathVariable String id, @RequestBody Map<String, String> message) {
        Map<String, String> messageFromDb = getMessage(id);
        messageFromDb.putAll(message);
        messageFromDb.put("id", id);
        return messageFromDb;
    }

    private Map<String, String> getMessage(String id) {
        return messages.stream()
                .filter(message -> message.get("id").equals(id))
                .findFirst()
                .orElseThrow(NotFountException::new);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable String id) {
        messages.remove(getMessage(id));
    }
}
