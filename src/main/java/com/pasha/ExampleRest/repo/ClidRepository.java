package com.pasha.ExampleRest.repo;

import com.pasha.ExampleRest.entities.Clid;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClidRepository extends CrudRepository<Clid, String> {}
