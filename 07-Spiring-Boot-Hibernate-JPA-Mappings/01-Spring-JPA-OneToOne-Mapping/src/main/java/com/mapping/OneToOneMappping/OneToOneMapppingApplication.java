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
			create(dao);
	   };
   }

   public void create(InstructorDAO dao)
   {
	   Instructor instructor = new Instructor("Sohan","Prasad","sohan@gmail.com");
	   InstructorDetails instructorDetails = new InstructorDetails("https://youtu.be/pC8m7gVIrDQ","Making-Videos");
	   instructor.setInstructorDetails(instructorDetails);
	   System.out.println("Creating Object....");
	   dao.save(instructor);
	   System.out.println("Object has Saved....");
   }
}
