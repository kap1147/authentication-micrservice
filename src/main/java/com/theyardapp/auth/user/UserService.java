package com.theyardapp.auth.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> findAll(){return userRepository.findAll();}

    public User findById(String id){
        if(userRepository.findById(id).isPresent()) return userRepository.findById(id).get();
        return null;
    }

    public void save(User user) {
        userRepository.save(user);
    }
}
