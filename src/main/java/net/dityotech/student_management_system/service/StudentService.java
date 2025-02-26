package net.dityotech.student_management_system.service;

import net.dityotech.student_management_system.entity.Student;
import net.dityotech.student_management_system.exception.StudentNotFoundException;
import net.dityotech.student_management_system.repository.StudentRepository;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

//    @Autowired
//    private StudentRepository studentRepository;

    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public void deleteStudent(Long id){
        Optional<Student> student = studentRepository.findById(id);
        if(student.isPresent())  {
            studentRepository.deleteById(id);
        } else {
            throw new StudentNotFoundException("Student having id " + id + " does not exist.");
        }
    }

    public Student saveStudent(Student student) {
        return studentRepository.save(student);
    }

    public Student updateStudent(Student student) {
        Optional<Student> existingStudent = studentRepository.findById(student.getSid());
        if(existingStudent.isPresent()) { // If student exists
            return studentRepository.save(student);
        } else { // If student does not exist
            throw new StudentNotFoundException("Student having id " + student.getSid() + " does not exist.");
        }
    }

    public Student updatePartialStudent(Student student) {
        Optional<Student> existingStudent = studentRepository.findById(student.getSid());
        if(existingStudent.isPresent()) {
            Student std = existingStudent.get();// If student exists
            if(student.getName() != null) {
                std.setName(student.getName());
            }
            if(student.getAddress() != null) {
                std.setAddress(student.getAddress());
            }
            if(student.getAge() != null) {
                std.setAge(student.getAge());
            }
            if(student.getEmail() != null) {
                std.setEmail(student.getEmail());
            }
            if(student.getGender() != null){
                std.setGender(student.getGender());
            }
            return studentRepository.save(std);
        } else { // If student does not exist
            throw new StudentNotFoundException("Student having id " + student.getSid() + " does not exist.");
        }
    }

    public List<Student> getStudentsWithAgeGreaterThan(Byte age){
        return studentRepository.getStudentsWithAgeGreaterThan(age);
    }

    public List<Student> getSelectedStudents(Byte age, String gender) {
        return studentRepository.getSelectedStudents(age, gender.toLowerCase());
    }

    public List<Student> getFilteredStudents(String filter) {
        //return studentRepository.findByAddress(filter);
        return studentRepository.findByGenderContaining(filter);
    }
}
