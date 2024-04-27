package com.getajob.springboot.restapicruddemo.service.impl;

import com.getajob.springboot.restapicruddemo.dao.EmployeeDAO;
import com.getajob.springboot.restapicruddemo.entity.Employee;
import com.getajob.springboot.restapicruddemo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {


    @Autowired
    private EmployeeDAO employeeDAO;

    @Autowired
    public EmployeeServiceImpl(EmployeeDAO employeeDAO) {
        this.employeeDAO = employeeDAO;
    }

    @Override
    public List<Employee> findAll() {
        return employeeDAO.findAll();
    }


    @Override
    public Employee findById(int id) {
        return employeeDAO.findById(id);
    }

    @Override
    @Transactional
    public Employee update(Employee employee) {
        return employeeDAO.update(employee);
    }

    @Override
@Transactional
    public Employee save(Employee employee){
    return employeeDAO.save(employee);
    }

    @Override
    @Transactional
    public int delete(int id) {
        return employeeDAO.delete(id);

    }
}
