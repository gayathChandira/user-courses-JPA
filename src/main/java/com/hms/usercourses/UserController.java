package com.hms.usercourses;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    UserService service;


    @PostMapping(path = "/add", consumes = "application/x-www-form-urlencoded")
    public void addUsers( User user) {
        System.out.println(user);
         service.add(user);
    }

    @GetMapping("/user")
    public User getUser(@RequestParam("id") long id) {
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
    public void editUser(User user, @PathVariable long id){
        System.out.println(id);
        System.out.println(user);
        service.edit(user, id);
    }
}
