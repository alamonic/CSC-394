package com.capstone.backend.data.repos;

import com.capstone.backend.data.models.Response;
import com.capstone.backend.data.models.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ResponseRepository extends CrudRepository<Response, String> {
    Iterable<Response> findAllByUserId(User s);
}
