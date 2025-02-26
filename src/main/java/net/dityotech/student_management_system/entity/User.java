package net.dityotech.student_management_system.entity;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class User {
    private String username;
    private String password;
    private String email;
}
