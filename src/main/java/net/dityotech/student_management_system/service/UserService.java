package net.dityotech.student_management_system.service;

import lombok.RequiredArgsConstructor;
import net.dityotech.student_management_system.controller.UserController;
import net.dityotech.student_management_system.dto.UserDTO;
import net.dityotech.student_management_system.entity.User;
import net.dityotech.student_management_system.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserService.class);

    private final UserRepository userRepository;

    public List<UserDTO> getUsers(){
        List<User> users = userRepository.getUsers();
        System.out.println("Users: ");
        users.forEach(user -> System.out.println(user));
        // User => UserDTO
        List<UserDTO> userDTOS = new ArrayList<>();

        for(User user: users) {
            //UserDTO userDTO = new UserDTO();
            //BeanUtils.copyProperties(user, userDTO);

            UserDTO userDTO = UserDTO.builder()
                            .username(user.getUsername())
                                    .email(user.getEmail()).build();
            userDTOS.add(userDTO);
        }
        System.out.println("UserDTOs: ");
        userDTOS.forEach(user -> System.out.println(user));
        return userDTOS;
    }
}
