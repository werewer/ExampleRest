package com.pasha.ExampleRest.repo;

import com.pasha.ExampleRest.entity.Clid;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClidDbRepository extends CrudRepository<Clid, String> {}
