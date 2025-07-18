package com.mapping.OneToOneMappping;

import com.mapping.OneToOneMappping.dao.InstructorDAO;
import com.mapping.OneToOneMappping.entity.Instructor;
import com.mapping.OneToOneMappping.entity.InstructorDetails;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class OneToOneMapppingApplication {

	public static void main(String[] args) {
		SpringApplication.run(OneToOneMapppingApplication.class, args);

	}
	@Bean
   public CommandLineRunner commandLineRunner(InstructorDAO dao)
   {
	   return runner->
	   {
           //createInstructorDetails(dao);
		   findInstructorDetails(dao);

	   };
   }

   public void findInstructorDetails(InstructorDAO dao)
   {
	   int id = 4;
	   InstructorDetails details = dao.findInstructorDetailsById(id);
	   System.out.println("Instructor-Details: "+details);
	   System.out.println("Instructor associated by Instructor-Details: "+details.getInstructor());
   }

   public void deleteInstructorDetails(InstructorDAO dao)
   {
	   int id = 2;
	   dao.deleteInstructorDetailsById(id);
	   System.out.println("Deleted ID is: "+id);
   }

	public void createInstructorDetails(InstructorDAO dao)
	{
		Instructor instructor = new Instructor("Barbel","Pitch","barbel@gmail.com");
		InstructorDetails instructorDetails = new InstructorDetails("https://www.youtube.com/watch?v=QsaYDIFdy34&pp=0gcJCcwJAYcqIYzv","Pitch-Meetings");
		instructor.setInstructorDetails(instructorDetails);
		instructorDetails.setInstructor(instructor);
		System.out.println("Creating Object....");
		dao.saveInstructor(instructor);
		System.out.println("Object has Saved....");
	}

   public void createInstructor(InstructorDAO dao)
   {
	   Instructor instructor = new Instructor("Raju","Prasad","raju@gmail.com");
	   InstructorDetails instructorDetails = new InstructorDetails("https://www.youtube.com/watch?v=wyfQ9E2hBPk&t=4s","Playing-Outdoor-Games");
	   instructor.setInstructorDetails(instructorDetails);
	   System.out.println("Creating Object....");
	   dao.saveInstructor(instructor);
	   System.out.println("Object has Saved....");
   }

   public void findInstructor(InstructorDAO dao)
   {
	   int id = 1;
	   Instructor instructor = dao.findById(id);
	   System.out.println("Instructor :"+instructor);
	   System.out.println("Instructor-Details:"+instructor.getInstructorDetails());
   }

   public void deleteInstructor(InstructorDAO dao)
   {
	   int id = 2;
	   dao.deleteInstructorById(id);
	   System.out.println("Delete Instructor ID is: "+id);
   }
}
