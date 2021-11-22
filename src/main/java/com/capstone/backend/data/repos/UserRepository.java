package com.capstone.backend.data.repos;

import com.capstone.backend.data.models.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface UserRepository extends CrudRepository<User, String> {
    Iterable<User> findAllByPassword(String password);

}
