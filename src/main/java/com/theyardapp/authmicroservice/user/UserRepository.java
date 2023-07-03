package com.theyardapp.authmicroservice.user;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

public interface UserRepository extends MongoRepository<User, String>{
    @Query("{username:'?0'}")
    Optional<User>  findItemByUsername(String username);

    Optional<User> findItemByEmail(String email);
}
