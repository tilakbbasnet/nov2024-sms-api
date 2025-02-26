package net.dityotech.student_management_system.exception;

import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleValidationException(MethodArgumentNotValidException exception){
        System.out.println("inside handle validation exception");
        Map<String, String> fieldErrors = new HashMap<>();
        exception.getBindingResult().getFieldErrors().forEach(
                fieldError -> fieldErrors.put(fieldError.getField(), fieldError.getDefaultMessage())
        );
        return fieldErrors;
    }

    @ExceptionHandler(StudentNotFoundException.class)
    public String handleStudentNotFoundException(StudentNotFoundException exception) {
        return exception.getMessage();
    }
}
