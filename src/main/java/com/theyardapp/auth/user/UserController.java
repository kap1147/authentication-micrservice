package com.theyardapp.auth.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path="api/v1/user")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    // @GetMapping
    // public List<User> getUser() {return userService.findAll();}

    @GetMapping
    public UserProjection getUser(@RequestParam(required = true, defaultValue = "") String username) {
        return userService.findIdByUsername(username);}

    @PostMapping()
    public void createUser(@RequestBody User user) {userService.save(user);}

    @PostMapping("debug")
    public void debugOutput(@RequestBody User user) {
        System.out.print(user);
    }
}