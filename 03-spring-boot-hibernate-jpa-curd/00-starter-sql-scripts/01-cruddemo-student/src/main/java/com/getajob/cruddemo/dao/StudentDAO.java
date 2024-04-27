package com.getajob.cruddemo.dao;

import com.getajob.cruddemo.entity.Student;

import java.util.List;

public interface StudentDAO {

    public void save(Student saveStudent);

    public Student read(Student readStudent);

    public List<Student> readMultipleStudent(String lastname);

    public void update(Student updateStudent);

    public void delete(Student deleteStudent);

    public int deleteAll();
}
