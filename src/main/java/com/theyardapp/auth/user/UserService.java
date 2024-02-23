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

    public User findByUsername(String username){
        if(userRepository.findByUsername(username).isPresent()) return userRepository.findByUsername(username).get();
        return null;
    }

    public UserProjection findIdByUsername(String username){
        if(userRepository.findIdByUsername(username).isPresent()) return userRepository.findIdByUsername(username).get();
        return null;
    }

    public void save(User user) {
        userRepository.save(user);
    }
}
