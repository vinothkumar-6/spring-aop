package com.getajob.cruddemo.dao.impl;
import com.getajob.cruddemo.entity.Student;
import com.getajob.cruddemo.dao.StudentDAO;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class StudentDAOImpl implements StudentDAO {

    //defining field for entity manager
    private EntityManager entityManager;

    //inject entity manager using constructor injection
    @Autowired
    public StudentDAOImpl(EntityManager theEntityManager){
        this.entityManager = theEntityManager;
    }
    //implementing save method
    @Override
    @Transactional(readOnly = false)
    public void save(Student saveStudent) {
        entityManager.persist(saveStudent);
    }

    @Override
    public Student read(Student readStudent) {
        return entityManager.find(readStudent.getClass(), readStudent.getId());

    }

    @Override
    public List<Student> readMultipleStudent(String lastName) {
        TypedQuery<Student> theQuery = entityManager.createQuery("FROM Student where lastName =:lastName", Student.class);
        theQuery.setParameter("lastName", lastName);
        return theQuery.getResultList();

    }

    @Override
    @Transactional
    public void update(Student updateStudent) {
        Student theStudent = entityManager.find(updateStudent.getClass(), updateStudent.getId());
        theStudent.setLastName(updateStudent.getLastName());
        entityManager.merge(theStudent);
    }

    @Override
    @Transactional
    public void delete(Student deleteStudent) {
        Student theStudent = entityManager.find(deleteStudent.getClass(), deleteStudent.getId());
        entityManager.remove(theStudent);
    }

    @Override
    @Transactional
    public int deleteAll() {
       int deleted = entityManager.createQuery("DELETE FROM Student").executeUpdate();
        return deleted;
    }
}
