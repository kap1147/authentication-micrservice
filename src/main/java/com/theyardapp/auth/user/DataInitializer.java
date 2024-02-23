package com.theyardapp.auth.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import java.util.Collections;
import java.util.HashSet;

import com.theyardapp.auth.config.ApplicationConfig;
import org.springframework.core.env.Environment;

import com.theyardapp.auth.user.Role;
import lombok.RequiredArgsConstructor;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Component
@RequiredArgsConstructor
public class DataInitializer implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    private final Environment environment;
    
    @Override
    public void run(String... args) throws Exception {
        String adminUserName = environment.getProperty("ADMIN_USER");
        if (userRepository.findByUsername(adminUserName).isEmpty()) {
            HashSet<Role> adminRole = new HashSet<Role>();
            adminRole.add(Role.USER);
            adminRole.add(Role.ADMIN);
            User adminUser = new User();
            adminUser.setUsername(adminUserName);
            adminUser.setPassword(bCryptPasswordEncoder.encode(environment.getProperty("ADMIN_PASSWORD")));
            adminUser.setRoles(adminRole);
            userRepository.save(adminUser);
        }
    }
}
