package com.pasha.ExampleRest.services;

import com.pasha.ExampleRest.entities.Clid;
import com.pasha.ExampleRest.repo.ClidFakeRepository;
import com.pasha.ExampleRest.repo.ClidRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ClidServiceDb implements ClidService {

//    private final ClidRepository repository;
//
//    public ClidServiceDb(ClidRepository repository) {
//        this.repository = repository;
//    }

    @Autowired
    ClidFakeRepository repository;

    @Override
    public List<Clid> findAllClid() {
        List<Clid> list = new ArrayList<>();
        repository.findAll().forEach(list::add);
        return list;
    }

    @Override
    public Clid findClidById(String id) {
        return repository.findById(id);
    }
}
