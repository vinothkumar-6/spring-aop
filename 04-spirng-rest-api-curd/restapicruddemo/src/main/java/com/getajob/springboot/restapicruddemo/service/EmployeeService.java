package com.getajob.springboot.restapicruddemo.service;

import com.getajob.springboot.restapicruddemo.entity.Employee;

import java.util.List;

public interface EmployeeService {
    public List<Employee> findAll();
    public Employee save(Employee employee);
    public int delete(int id);
    public Employee findById(int id);

    public Employee update(Employee employee);
}
