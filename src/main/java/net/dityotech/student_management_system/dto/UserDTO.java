package net.dityotech.student_management_system.dto;

import lombok.*;
import org.springframework.stereotype.Service;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {
    // Security, Performance, Encapsulation

    private String username;
    private String email;
}
