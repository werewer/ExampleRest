package com.pasha.ExampleRest.controller;

import com.pasha.ExampleRest.entities.Address;
import com.pasha.ExampleRest.entities.Clid;
import com.pasha.ExampleRest.services.AddressClientServiceRest;
import com.pasha.ExampleRest.services.ClidServiceDb;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("addr/getcliddata")
public class ClidRestController {

    private final ClidServiceDb clidService;
    private final AddressClientServiceRest addressClientServiceRest;

    public ClidRestController(ClidServiceDb clidService, AddressClientServiceRest addressClientServiceRest) {
        this.clidService = clidService;
        this.addressClientServiceRest = addressClientServiceRest;
    }

    @GetMapping
    public List<Clid> getAll() {
        return clidService.findAllClid();
    }

    @GetMapping("{clid_id}")
    public Clid getClidByAddrId(@PathVariable("clid_id") String clidId) {
        Clid clid = clidService.findClidById(clidId);
        Address addr = addressClientServiceRest.findAddressById(clid.getAddrId());
        clid.setAddress(addr);
        return clid;
    }

    @GetMapping("{clid_id}")
    public Clid getClidByAddrIds(@PathVariable("clid_id") String clidId) {
        Clid clid = clidService.findClidById(clidId);
        Address addr = addressClientServiceRest.findAddressById(clid.getAddrId());
        clid.setAddress(addr);
        return clid;
    }

}
