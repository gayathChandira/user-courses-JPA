package com.hms.usercourses.services;

import com.hms.usercourses.domain.User;
import com.hms.usercourses.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Component;

import java.util.List;

@EnableAutoConfiguration
@Component
public class UserService {

    @Autowired
    private UserRepository repository;

    private static final Logger log = LoggerFactory.getLogger(UserService.class);

    public void add(User usr) {
        System.out.println("this is service");
        System.out.println(usr);

        repository.save(new User(usr.getF_name(), usr.getL_name(), usr.getAge(), usr.getEmail(), usr.getContact()));
    }

    public String delete(long id) {
        String msg = "Deleted";
        repository.deleteById(id);
        return msg;
    }

    public void edit(User usr, long id) {
        repository.findById(id).map(user -> {
            user.setF_name(usr.getF_name());
            user.setL_name(usr.getL_name());
            user.setAge(usr.getAge());
            user.setEmail(usr.getEmail());
            user.setContact(usr.getContact());
            return repository.save(user);
        });
    }

    public User getUserbyId(long id) {
        return repository.findById(id).get();
    }

    public List<User> getAllUsers() {
        return (List<User>) repository.findAll();
    }
}
