package net.dityotech.student_management_system.repository;

import net.dityotech.student_management_system.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

    @Query(value = "SELECT * FROM STUDENTS WHERE AGE > :age", nativeQuery = true)
    List<Student> getStudentsWithAgeGreaterThan(Byte age);

    @Query(value = "SELECT * FROM STUDENTS WHERE AGE > :age AND LOWER(gender) = :gender", nativeQuery = true)
    List<Student> getSelectedStudents(Byte age, String gender);

    //Derived Query Methods
    List<Student> findByAddress(String address);

    List<Student> findByGenderContaining(String gender);
}
