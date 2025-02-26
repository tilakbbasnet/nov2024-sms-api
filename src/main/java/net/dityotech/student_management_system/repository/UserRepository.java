package net.dityotech.student_management_system.repository;

import net.dityotech.student_management_system.controller.UserController;
import net.dityotech.student_management_system.dto.UserDTO;
import net.dityotech.student_management_system.entity.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserRepository {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserRepository.class);

    public List<User> getUsers(){
        User user = User.builder()
                .username("john")
                .password("john123")
                .email("john@gmail.com")
                .build();


        User user1 = User.builder()
                .username("justin")
                .password("justin123")
                .email("justin@gmail.com")
                .build();
        return List.of(user, user1);
    }
}
