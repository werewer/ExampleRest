package com.pasha.ExampleRest.services;

import com.pasha.ExampleRest.entity.Clid;
import com.pasha.ExampleRest.repo.ClidDbRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
public class ClidServiceDb implements ClidService {

    private final ClidDbRepository repository;

    public ClidServiceDb(ClidDbRepository repository) {
        this.repository = repository;
    }

    @Override
    public Collection<Clid> findAllClid() {
        List<Clid> list = new ArrayList<>();
        repository.findAll().forEach(list::add);
        return list;
    }

    @Override
    public Clid findClidById(String id) {
        return repository.findById(id).orElse(new Clid());
    }

    @Override
    public Collection<Clid> findClidsByIdList(Collection<String> ids) {
        List<Clid> clids = new ArrayList<>();
        repository.findAllById(ids).forEach(clids::add);
        return clids;
    }
}
