package com.HibernateJpa.CrudDemo;

import com.HibernateJpa.CrudDemo.dao.StudentDAO;
import com.HibernateJpa.CrudDemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

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

			// create object
	//		createStudent(studentDAO);

			createMultipleStudents(studentDAO);

			// read object
	//		readStudent(studentDAO);

			// retrieve Student object list
	//		queryForStudents(studentDAO);

	//		queryForStudentsByLastName(studentDAO);

			// update an object
	//		updateStudent(studentDAO);

			// delete an object
	//		deleteStudent(studentDAO);

			// deleting all objects
	//		deleteAllStudents(studentDAO);

		};
	}

	private void deleteAllStudents(StudentDAO studentDAO) {

		System.out.println("Deleting all students");
		int numRowsDeleted = studentDAO.deleteAll();
		System.out.println("Deleted row count: " +  numRowsDeleted);
	}

	private void deleteStudent(StudentDAO studentDAO) {

		int studentId = 3;
		System.out.println("Deleting student id: " + studentId);
		studentDAO.delete(studentId);
	}

	private void updateStudent(StudentDAO studentDAO) {

		// retrieve student based on the id: primary Key
		int studentId = 1;
		System.out.println("Getting student with id: " + studentId);
		Student myStudent = studentDAO.findById(studentId);

		// change first name
		System.out.println("Updating student ...");
	//	myStudent.setFirstName("Scooby");
		myStudent.setFirstName("John");


		// update the student
		studentDAO.update(myStudent);

		// display the updated student
		System.out.println("Updated student: " + myStudent);

	}

	private void queryForStudentsByLastName(StudentDAO studentDAO) {

		// get a list of students
		List<Student> theStudents = studentDAO.findByLastName("Bhat");

		// display list of students
		for(Student tempStudent: theStudents) {
			System.out.println(tempStudent);
		}
	}

	private void queryForStudents(StudentDAO studentDAO) {

		// get a list of students
		List<Student> theStudents = studentDAO.findAll();

		// display a list of students
		for(Student tempStudent: theStudents) {
			System.out.println(tempStudent);
		}


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

	private void createMultipleStudents(StudentDAO studentDAO) {

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
