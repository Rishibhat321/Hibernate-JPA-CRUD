package com.HibernateJpa.CrudDemo.dao;

import com.HibernateJpa.CrudDemo.entity.Student;

public interface StudentDAO {

    void save(Student theStudent);

    Student findById(Integer id);
}
