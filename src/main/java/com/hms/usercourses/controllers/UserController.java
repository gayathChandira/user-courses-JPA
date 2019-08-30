package com.hms.usercourses.controllers;


import com.hms.usercourses.services.UserService;
import com.hms.usercourses.domain.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    UserService service;

    private static final Logger logger
            = LoggerFactory.getLogger(UserController.class);

    @PostMapping(path = "/add", consumes = "application/x-www-form-urlencoded")
    public void addUsers(User user) {
        System.out.println(user);
        service.add(user);
    }

    @GetMapping("/user")
    public User getUser(@RequestParam("id") long id) {
        logger.info("Example log from {}");
        return service.getUserbyId(id);
    }

    @GetMapping("/all")
    public List<User> findAllUsers() {
        return service.getAllUsers();
    }

    @DeleteMapping("/delete")
    public String deleteUser(@RequestParam("id") long id) {
        return service.delete(id);
    }

    @PutMapping("/edit/{id}")
    public void editUser(User user, @PathVariable long id) {
        System.out.println(id);
        System.out.println(user);
        service.edit(user, id);
    }
}
