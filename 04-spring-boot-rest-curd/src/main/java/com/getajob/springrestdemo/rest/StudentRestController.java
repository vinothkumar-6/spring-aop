package com.getajob.springrestdemo.rest;

import com.getajob.springrestdemo.entity.Student;
import com.getajob.springrestdemo.expection.StudentNotFoundException;
import jakarta.annotation.PostConstruct;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {

    List<Student>  studentList = new ArrayList<>();

    @PostConstruct
    public void loadStudent(){
        studentList.add(new Student("Vinoth Kumar","Jayandiran","1"));
        studentList.add(new Student("Vignesh", "Thakali","2"));
        studentList.add(new Student("Gopi","Devarajan","3"));
        studentList.add(new Student("Gopi","Devarajan","1"));
    }



    @GetMapping("/students")
    public List<Student> getStudent(){

        return studentList;
    }

    @GetMapping("/student/{studentId}")
    public List<Student> getStudentbyId(@PathVariable String studentId) {
        List<Student> returnStudent = new ArrayList<>();
        if(studentId.equalsIgnoreCase("0")) {
            throw new StudentNotFoundException("student id should not be " + studentId);
        }
        for(Student s: studentList) {
            if (s.getId().equalsIgnoreCase(studentId)) {
                returnStudent.add(s);
            }
        }
        return returnStudent;
    }
}
