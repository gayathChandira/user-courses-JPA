package com.hms.usercourses;

import com.hms.usercourses.controllers.UserController;
import com.hms.usercourses.domain.User;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Repository;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Repository
class UserControllerTest {

    @Autowired
    UserController controller;

    @Test
    void findAllUsers() {
        List<User> usr = controller.findAllUsers();
        assertThat(usr).isNotNull();
        User result = usr.get(0);
        assertThat(result).hasFieldOrPropertyWithValue("f_name", "Pradeep");
    }
}