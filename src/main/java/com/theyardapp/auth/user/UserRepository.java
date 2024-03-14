package com.theyardapp.auth.user;

import java.util.Optional;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, String> {
        Optional<User> findByEmail(String email);

        Optional<User> findByUsername(String username);

        Optional<UserProjection> findIdByUsername(String username);
        
        Optional<User> findById(String id);
}