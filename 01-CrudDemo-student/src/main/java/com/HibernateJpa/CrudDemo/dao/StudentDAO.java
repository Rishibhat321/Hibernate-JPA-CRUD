package com.HibernateJpa.CrudDemo.dao;

import com.HibernateJpa.CrudDemo.entity.Student;

import java.util.List;

public interface StudentDAO {

    void save(Student theStudent);

    Student findById(Integer id);

    List<Student> findAll();

    List<Student> findByLastName(String theLastName);

    void update(Student theStudent);

    void delete(Integer id);

    // delete all the students from the db
    int deleteAll();

}
