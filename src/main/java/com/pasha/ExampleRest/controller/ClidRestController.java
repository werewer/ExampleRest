package com.pasha.ExampleRest.controller;

import com.pasha.ExampleRest.entity.Address;
import com.pasha.ExampleRest.entity.Clid;
import com.pasha.ExampleRest.services.AddressClientServiceRest;
import com.pasha.ExampleRest.services.ClidService;
import com.pasha.ExampleRest.services.ClidServiceDb;
import com.pasha.ExampleRest.services.ClidServiceDbFake;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("addr/getcliddata")
public class ClidRestController {

//    @Resource(type = ClidServiceDbFake.class)
    private final ClidService clidService;
    private final AddressClientServiceRest addressClientServiceRest;

    public ClidRestController(ClidServiceDb clidService, AddressClientServiceRest addressClientServiceRest) {
        this.clidService = clidService;
        this.addressClientServiceRest = addressClientServiceRest;
    }

    @GetMapping
    public Collection<Clid> getAll() {
        return clidService.findAllClid();
    }

    @GetMapping("{clid_id}")
    public Collection<Clid> getClidByAddrIds(@PathVariable("clid_id") String[] clidIds) {
        Collection<Clid> clids = clidService.findClidsByIdList(List.of(clidIds));
        List<Long> addrIds = clids.stream().map(Clid::getAddrId).collect(Collectors.toCollection(() -> new ArrayList<>(clids.size())));
        List<Address> addrList = addressClientServiceRest.findAddressByIds(addrIds);
        clids.forEach(clid -> addrList.stream().filter(addr -> clid.getAddrId().equals(addr.getId())).findFirst().ifPresent(clid::setAddress));
        return clids;
    }

}
