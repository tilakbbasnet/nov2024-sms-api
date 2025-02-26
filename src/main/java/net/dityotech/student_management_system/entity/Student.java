package net.dityotech.student_management_system.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import net.dityotech.student_management_system.model.Address;

import java.util.List;

@Entity
@Table(name = "STUDENTS")
//@ToString
//@Getter
//@Setter
@NoArgsConstructor
@AllArgsConstructor
@Data //@getter, @setter, @tostring, @equalsandhashcode, @requiredargsconstructor
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "student_id")
    private Long sid;

    @NotNull(message = "Name cannot be null")
    @Column(name = "full_name")
    private String name;

    @Email(message = "Invalid email address")
    private String email;

    @NotNull(message = "Please provide gender")
    @NotBlank(message = "Gender cannot be blank")
    private String gender;

    @Max(value = 120, message = "Age cannot exceed 120")
    private Byte age;
    //private List<String> hobbies;
    private String address;
}
