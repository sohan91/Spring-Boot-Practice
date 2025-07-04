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
				insertInDB(student);
		  // readStudentDetails(student);
//		   getAllStudent(student);
//		   getFirstNameList(student);
//		   updateName(student);
		  // remove(student);
//		   removeAll(student);
	   };
   }
   public void insertInDB(StudentDAO studentDAO)
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

	   int id = 2;
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
   public void updateName(StudentDAO studentDAO)
   {
      int id = 2;
	  Student student = studentDAO.getDetails(id);
	   System.out.println("Student is: "+student);
	   student.setFirstName("SreeRamaDasu");
	   studentDAO.update(student);
	   System.out.println("Successfully Updates");
   }

   public void remove(StudentDAO studentDAO)
   {
	   int id = 4;
	   try {
		   System.out.println("Delete Student ID:" + id);
		   studentDAO.delete(id);
		   System.out.println("Successfully Deleted!!!");
	   }catch (Exception e)
	   {
		   System.out.println("Already Student is Deleted!! ");
	   }
   }

   public void removeAll(StudentDAO studentDAO)
   {
	   System.out.println("Deleting All Student...");
	   int affected = studentDAO.deleteAll();
	   System.out.println(affected+" were affected...");
   }
}
