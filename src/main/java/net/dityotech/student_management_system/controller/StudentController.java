package net.dityotech.student_management_system.controller;

import jakarta.validation.Valid;
import net.dityotech.student_management_system.entity.Student;
import net.dityotech.student_management_system.service.StudentService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {

//    @Autowired
//    private StudentService studentService;

    private final StudentService studentService;

    public StudentController(StudentService studentService){
        this.studentService = studentService;
    }

    // http://localhost:8080/student
    @PostMapping
    public ResponseEntity<Student> saveStudent(@Valid @RequestBody Student student) {
        //return new ResponseEntity<>(studentService.saveStudent(student), HttpStatus.CREATED);
        //return ResponseEntity.status(HttpStatus.CREATED).body(studentService.saveStudent(student));

        return ResponseEntity.status(HttpStatus.NOT_FOUND).headers(new HttpHeaders()).body(studentService.saveStudent(student));
    }

    // URL: http://localhost:8080/student
    @GetMapping
    public ResponseEntity<List<Student>> getAllStudents() {
        return ResponseEntity.ok(studentService.getAllStudents());
    }

    // URL:http://localhost:8080/student/4
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteStudent(@PathVariable("id") Long id){
        studentService.deleteStudent(id);
        return ResponseEntity.ok("Student deleted successfully");
    }

    // URL:http://localhost:8080/student
    @PutMapping
    public Student updateStudent(@RequestBody Student student){
        return studentService.updateStudent(student);
    }

    // URL:http://localhost:8080/student
    @PatchMapping
    public Student updatePartialStudent(@RequestBody Student student){
        return studentService.updatePartialStudent(student);
    }

    @GetMapping("/{age}")
    public List<Student> getStudentsWithAgeGreaterThan(@PathVariable("age") Byte age) {
        return studentService.getStudentsWithAgeGreaterThan(age);
    }

    @GetMapping("/{age}/{gender}")
    public List<Student> getSelectedStudents(@PathVariable("age") Byte age, @PathVariable("gender") String gender) {
        return studentService.getSelectedStudents(age, gender);
    }

    @GetMapping("/search/{filter}")
    public List<Student> getFilteredStudents(@PathVariable("filter") String filter) {
        return studentService.getFilteredStudents(filter);
    }
}
