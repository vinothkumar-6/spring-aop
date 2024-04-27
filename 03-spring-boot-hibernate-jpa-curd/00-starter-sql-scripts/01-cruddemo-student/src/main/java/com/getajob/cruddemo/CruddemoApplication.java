package com.getajob.cruddemo;

import com.getajob.cruddemo.dao.StudentDAO;
import com.getajob.cruddemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import java.util.List;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO){
		return runner ->{
			System.out.println("Hello Vinoth! Welcome to Springboot Hibernate JPA CRUD APPLICATION");
			//createStudent(studentDAO);
			createMultipleStudents(studentDAO);
			//readStudent(studentDAO);
			//readMultipleStudents(studentDAO);
			//updateStudentLastName(studentDAO);
			//deleteStudentId(studentDAO);
			//deleteAllStudent(studentDAO);
		};
	}


	private void createStudent(StudentDAO studentDAO){

		System.out.println("Creating new Student object...");
		Student student = new Student("Vinoth Kumar","Jayandiran","vinothkumar.j@outlook.com");


		System.out.println("Saving student object");
		studentDAO.save(student);

		System.out.println("Displaying id of saving student" + student.getId());
	}
	private void createMultipleStudents(StudentDAO studentDAO){

		System.out.println("Creating Multiple student object...");
		Student student1 = new Student("Vinoth Kumar","Jayandiran","vinothkumar.j@outlook.com");
		Student student2 = new Student("Keerthana","Vinoth Kumar","keerthana.siva1602@gmail.com");
		Student student3 = new Student("Geetha","Jayandiran","geethajayan@gmail.com");

		studentDAO.save(student1);
		studentDAO.save(student2);
		studentDAO.save(student3);
		System.out.println("Multiple student objects created");
	}

	private void readStudent(StudentDAO studentDAO){

		System.out.println("Reading Student data...");
		Student student = new Student();
        student.setId(1);
		Student data = studentDAO.read(student);
		System.out.println("Displaying id of reading student: " + data.getId());
		System.out.println("Displaying FirstName of reading student: " + data.getFirstName());
		System.out.println("Displaying LastName of reading student: " + data.getLastName());
	}

	private void readMultipleStudents(StudentDAO studentDAO){

		System.out.println("Reading Multiple Student data...");

		List<Student> students = studentDAO.readMultipleStudent("Vinoth Kumar");
		if (!students.isEmpty()){
			System.out.println("Total Numbe of Students in db: "+students.size());
			int i=1;
			for(Student s : students){
				System.out.println("Student "+i+ ": "+"id: "+s.getId()+" FirstName: "+s.getFirstName()+" LastName: "+s.getLastName()+" Email: "+s.getEmail());
				i++;
			}
		}
	}

	private void updateStudentLastName(StudentDAO studentDAO){
		Student student = new Student();
		student.setLastName("Sivakumar");
		student.setId(3);
		studentDAO.update(student);
        System.out.println("Student successfully updated");


	}
	private void deleteStudentId(StudentDAO studentDAO){
		Student student = new Student();
		student.setId(4);
		studentDAO.delete(student);
		System.out.println("Student successfully deleted");
	}

	private void deleteAllStudent(StudentDAO studentDAO){
		int deleted = studentDAO.deleteAll();
		System.out.println(deleted + " Students successfully deleted");
	}
}
