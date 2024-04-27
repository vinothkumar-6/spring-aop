package com.getajob.springboot.restapicruddemo.rest;

import com.getajob.springboot.restapicruddemo.entity.Employee;
import com.getajob.springboot.restapicruddemo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

    private EmployeeService employeeService;

    public EmployeeRestController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/employees")
    public List<Employee> findAll() {
        return employeeService.findAll();
    }

    @GetMapping("/employees/{employeeId}")
    public Employee findByid(@PathVariable int employeeId) {

        return employeeService.findById(employeeId);
    }


    @PostMapping("/employees")
    public Employee save(@RequestBody Employee employee) {
        employee.setId(0);
       Employee employees = employeeService.save(employee);
        return employees;

    }

    @PutMapping("/employees")
    public Employee update(@RequestBody Employee employee){
        Employee employee1 = employeeService.update(employee);
        return  employee1;
    }

    @DeleteMapping("/employees/{employeeId}")
    public int delete(@PathVariable int employeeId){
        return employeeService.delete(employeeId);

    }
}
