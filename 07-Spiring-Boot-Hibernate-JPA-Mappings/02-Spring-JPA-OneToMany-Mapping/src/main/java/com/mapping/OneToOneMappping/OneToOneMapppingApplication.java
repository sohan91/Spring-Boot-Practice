package com.mapping.OneToOneMappping;

import com.mapping.OneToOneMappping.dao.InstructorDAO;
import com.mapping.OneToOneMappping.entity.Course;
import com.mapping.OneToOneMappping.entity.Instructor;
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
			add(dao);
		   find(dao);
	   };
   }
    public void add(InstructorDAO dao)
	{
		Instructor instructor = new Instructor("Tom","kin","tom@gmail.com");
		Course course1 = new Course("Music-Teacher");
		Course course2 = new Course("Dance-Teacher");
		instructor.add(course1);
		instructor.add(course2);
		System.out.println("Creating the Object...");
		dao.saveInstructor(instructor);
		System.out.println("Saving the Object...");
	}

	public void find(InstructorDAO dao)
	{
		int id = 2;
		Instructor instructor = dao.findById(id);
		System.out.println("Instructor is: "+instructor);
		System.out.println("Course associate with Instructor is: "+instructor.getCourses());
	}
}
