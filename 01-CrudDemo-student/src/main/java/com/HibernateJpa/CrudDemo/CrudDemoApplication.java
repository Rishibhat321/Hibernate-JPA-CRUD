package com.HibernateJpa.CrudDemo;

import com.HibernateJpa.CrudDemo.dao.StudentDAO;
import com.HibernateJpa.CrudDemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CrudDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrudDemoApplication.class, args);
	}

/*	@Bean
	public CommandLineRunner commandLineRunner(String[] args) {
		return runner -> {
			System.out.println("Hello World");
		};
	}  */


	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {
		return runner -> {

	//		createStudent(studentDAO);

	//		createMultipeStudents(studentDAO);

			readStudent(studentDAO);
		};
	}

	private void readStudent(StudentDAO studentDAO) {

		// create a student object
		System.out.println("Creating a new student object ... ");
		Student tempStudent = new Student("John", "Bhat", "johnb@gmail.com");

		// save the student
		System.out.println("Saving the student");
		studentDAO.save(tempStudent);

		// display id of the saved student
		int theId = tempStudent.getId();
		System.out.println("Saved student Generated id: " + theId);

		// retrieve student based on the id: primary key
		System.out.println("Retreiving student with id: " + theId);
		Student myStudent = studentDAO.findById(theId);

		// display the student
		System.out.println("Found student: " + myStudent);

	}

	private void createMultipeStudents(StudentDAO studentDAO) {

		// create multiple students
		System.out.println("Creating new student object ... ");
		Student tempStudent1 = new Student("John" , "Doe" , "john@gmail.com");
		Student tempStudent2 = new Student("Mary" , "Jane" , "mary@gmail.com");
		Student tempStudent3 = new Student("Rishi" , "Dubey" , "rishi@gmail.com");


		// save the student objects
		System.out.println("Saving the students...");
		studentDAO.save(tempStudent1);
		studentDAO.save(tempStudent2);
		studentDAO.save(tempStudent3);

	}

	private void createStudent(StudentDAO studentDAO) {

		// create the student object
		System.out.println("Creating new student object ... ");
		Student tempStudent = new Student("Sahil" , "Arora" , "sahil@gmail.com");

		// save the student object
		System.out.println("Saving the student...");
		studentDAO.save(tempStudent);

		// display the id of the saved student
		System.out.println("Saved student Generated id: " + tempStudent.getId());

	}

}
