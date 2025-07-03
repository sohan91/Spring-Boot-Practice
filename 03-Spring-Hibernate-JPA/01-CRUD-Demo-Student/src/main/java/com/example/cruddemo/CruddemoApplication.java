package com.example.cruddemo;


import com.example.cruddemo.dboperation.StudDAOImplementation;
import com.example.cruddemo.dboperation.Student;
import com.example.cruddemo.dboperation.StudentDAO;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args)
	{
		SpringApplication.run(CruddemoApplication.class, args);
	}
   @Bean
	public CommandLineRunner commandLineRunner(StudentDAO student)
   {
	   return runner->{
//				updateInDB(student);
		   readStudentDetails(student);
		   getAllStudent(student);
		   getFirstNameList(student);
	   };
   }
   public void updateInDB(StudentDAO studentDAO)
   {
	   System.out.println("Object is Creating....");
	   List<Student> students = new ArrayList<>();
	  Student s1 = new Student("Adisharlapalli","Chandrakala","chandrakala@443gmail.com");
	   Student s2 = new Student("mani","Teja",",mani@e323gmial.com");
	   Student s3 = new Student("raju","prasad","raju@33gmail.com");
	   System.out.println("Student is Saving...");
	   studentDAO.save(s1);
	   studentDAO.save(s2);
	   studentDAO.save(s3);
	   System.out.println("Student is Saved..!!");
   }
   public void readStudentDetails(StudentDAO studentDAO)
   {

	   int id = 5;
	   try {
		   System.out.println("Retriving Student Details of ID: " + id);
		   Student studentDetail = studentDAO.getDetails(id);
		   System.out.println("Student ID: " + studentDetail.getId());
		   System.out.println("Student First Name: " + studentDetail.getFirstName());
		   System.out.println("Student Last Name: " + studentDetail.getLastName());
		   System.out.println("E-Mail: " + studentDetail.getEmail());
	   }catch (Exception e) {
		   System.err.println("Details not Found on ID: " + id);
	   }
   }

   public void getAllStudent(StudentDAO studentDAO)
   {
	   List<Student> students = studentDAO.getAllStudentDetails();
	   List<Student> orderByStudent =studentDAO.getOrderByStudentName();

	   for(Student student : students)
	   {
		   System.out.println(student);
	   }
	   System.out.println("-".repeat(30));
	   for(Student student : orderByStudent)
	   {
		   System.out.println(student);
	   }

   }
   public void getFirstNameList(StudentDAO studentDAO)
   {
	   List<Student> students = studentDAO.findByFirstName("mani");
	   System.out.println("-".repeat(30));
	   for (Student student : students)
	   {
		   System.out.println(student);
	   }
	   System.out.println("-".repeat(30));
   }
}
