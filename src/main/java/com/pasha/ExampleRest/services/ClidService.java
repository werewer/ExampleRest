package com.pasha.ExampleRest.services;

import com.pasha.ExampleRest.entity.Clid;

import java.util.Collection;

public interface ClidService {
    Collection<Clid> findAllClid();
    Clid findClidById(String id);
    Collection<Clid> findClidsByIdList(Collection<String> id);
}
