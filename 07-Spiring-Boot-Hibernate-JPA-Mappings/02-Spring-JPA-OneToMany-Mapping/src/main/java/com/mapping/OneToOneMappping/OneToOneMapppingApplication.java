package com.mapping.OneToOneMappping;

import com.mapping.OneToOneMappping.dao.InstructorDAO;
import com.mapping.OneToOneMappping.entity.Course;
import com.mapping.OneToOneMappping.entity.Instructor;
import com.mapping.OneToOneMappping.entity.Review;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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
//			add(dao);
//		   find(dao);
//		   findCourse(dao);
//		   findInstructorUsingFetch(dao);
//		   updateInstructor(dao);
//		   updateCourse(dao);
//		   deleteInstructorById(dao);
//		   deleteCourseById(dao);
//		   saveCourseWithReview(dao);
//		   findCourseWithReview(dao);
		   deleteCourseWithReview(dao);
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

	private void findCourse(InstructorDAO dao) {
		int id = 2;
		Instructor instructor = dao.findById(id);
		List<Course> courses = dao.findListOfCoursesById(id);
		System.out.println("Instructor: " + instructor);
		instructor.setCourses(courses);
		System.out.println("Courses: " + instructor.getCourses()); // now allowed, session is open
	}
	private void findInstructorUsingFetch(InstructorDAO dao)
	{
		int id = 2;
		Instructor instructor = dao.findInstructorUsingFetchById(id);
		System.out.println("Instructor is: "+instructor);
		System.out.println("Course : "+instructor.getCourses());
	}

	private void updateInstructor(InstructorDAO dao)
	{
		int id = 2;
		Instructor instructor = dao.findById(id);
		instructor.setLastName("Tester");
		dao.updateInstructor(instructor);
		System.out.println("Successfully updated...");
	}

	private void updateCourse(InstructorDAO dao)
	{
		int id = 3;
		Course course = dao.findCourseById(id);
		System.out.println("Update Course details with id :"+id);
		course.setTitle("Maths-Teacher");
		dao.updateCourse(course);
		System.out.println("Successfully updated...");
	}
  private void deleteInstructorById(InstructorDAO dao)
  {
	  int id = 2;
	  dao.deleteInstructorById(id);
	  System.out.println("Successfully Deleted Instructor with ID: "+id);
  }
	private void deleteCourseById(InstructorDAO dao)
	{
		int id = 3;
		dao.deleteCourseById(id);
		System.out.println("Successfully Deleted Course with ID: "+id);
	}
	private void saveCourseWithReview(InstructorDAO instructorDAO)
	{
		Course course = new Course("C-Programming Beginner to Advance");
		course.add(new Review("Course was really good"));
		course.add(new Review("Expecting more practical example"));
		course.add(new Review("Good...Keep it Up!!"));
		System.out.println("Saved the course....");
		System.out.println(course);
		System.out.println(course.getReviewList());
		instructorDAO.saveReviewsOnCourse(course);
	}
	private void findCourseWithReview(InstructorDAO instructorDAO)
	{
		int id = 5;
		Course course = instructorDAO.findCourseWithReviewById(id);
		System.out.println("Course: "+course);
		System.out.println("Reviews: "+course.getReviewList());
	}
	private void deleteCourseWithReview(InstructorDAO dao)
	{
		int id = 5;
		dao.deleteCourseWithReviewById(id);
		System.out.println("Successfully Deleted Course with Id: "+id);
	}
}
