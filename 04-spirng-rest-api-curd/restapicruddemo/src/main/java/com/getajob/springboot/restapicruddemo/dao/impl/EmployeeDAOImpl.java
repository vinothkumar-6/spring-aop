package com.getajob.springboot.restapicruddemo.dao.impl;

import com.getajob.springboot.restapicruddemo.dao.EmployeeDAO;
import com.getajob.springboot.restapicruddemo.entity.Employee;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO {

    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    public EmployeeDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Employee> findAll() {
        TypedQuery<Employee> queryList = entityManager.createQuery("From Employee",Employee.class);
        List<Employee>  employees = queryList.getResultList();
        return employees;
    }

    @Override
    public Employee findById(int id) {
        Employee e = entityManager.find(Employee.class, id);
        if(e == null){
            throw new RuntimeException("Employee Not found");
        }
        return e;
    }

    @Override
    public Employee save(Employee employee){
        Employee savedEmployee = entityManager.merge(employee);
        return savedEmployee;
    }

    @Override
    public int delete(int id) {
        Employee e = entityManager.find(Employee.class, id);
        if(e == null){
            throw new RuntimeException("Employee Not found");
        } else{
            entityManager.remove(e);
        }
        return e.getId();

    }

    @Override
    public Employee update(Employee employee) {
        Employee e = entityManager.merge(employee);
        return e;
    }

}
