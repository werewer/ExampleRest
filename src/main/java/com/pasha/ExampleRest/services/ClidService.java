package com.pasha.ExampleRest.services;

import com.pasha.ExampleRest.entities.Clid;

import java.util.List;

public interface ClidService {
    List<Clid> findAllClid();
    Clid findClidById(String id);
}
