package com.getajob.springboot.restapicruddemo.dao;

import com.getajob.springboot.restapicruddemo.entity.Employee;
import javax.persistence.EntityManager;

import java.util.List;

public interface EmployeeDAO {

    public List<Employee> findAll();
    public Employee findById(int id);
    public Employee save(Employee employee);

    public int delete(int id);

    public Employee update(Employee employee);


}
