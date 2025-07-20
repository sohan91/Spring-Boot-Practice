package com.manytomany.manytomany;

import com.manytomany.manytomany.dao.StudentCourseDAO;
import com.manytomany.manytomany.entity.Course;
import com.manytomany.manytomany.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class ManyToManyMappingApplication {

	public static void main(String[] args) {
		SpringApplication.run(ManyToManyMappingApplication.class, args);
	}
 @Bean
	public CommandLineRunner commandLineRunner(StudentCourseDAO dao)
 	{
	 return runner->{
        deleteCourse(dao);
		deleteStudent(dao);
	  };
 	}

	 private void saveCourseForManyStudent(StudentCourseDAO studentCourseDAO)
	 {
		 System.out.println("-".repeat(30));
		 System.out.println("Save Course Details");
		 System.out.println("-".repeat(30));
		 Course course = new Course("JavaScript");
		 course.addStudent(new Student("shiva","nayak","shiva@gmail.com"));
		 course.addStudent(new Student("praveen","goud","praven@gmail.com"));
		 System.out.println("Saved student Data");
		 System.out.println("Course: "+course);
		 System.out.println("Student: "+course.getStudentList());
		 studentCourseDAO.save(course);
		 System.out.println("Done!!");
	 }

	 private void getCourseDetails(StudentCourseDAO dao)
	 {
		 System.out.println("-".repeat(30));
		 System.out.println("Course Details");
		 System.out.println("-".repeat(30));
		 int id = 12;
		 Course course = dao.findCourseDetailsById(id);
		 System.out.println("processing...");
		 List<Student> students = course.getStudentList();
		 System.out.println("Course on ID "+id+" is: "+course);
		 System.out.println("Student on ID "+id+" is: "+students);
	 }

	private void getStudentDetails(StudentCourseDAO dao)
	{
		System.out.println("-".repeat(30));
		System.out.println("Student Details");
		System.out.println("-".repeat(30));
		int id = 4;
		Student students = dao.findStudentDetailsById(id);
		System.out.println("processing...");
		List<Course> courses = students.getCourseList();
		System.out.println("Student on ID "+id+" is: "+students);
		System.out.println("Course on ID "+id+" is: "+courses);
		System.out.println();
	}

	private void saveStudentForManyCourse(StudentCourseDAO studentCourseDAO)
	{
		System.out.println("-".repeat(30));
		System.out.println("Save Student Details");
		System.out.println("-".repeat(30));
		int id = 3;
		Student student = studentCourseDAO.findStudentDetailsById(id);
		student.addCourse(new Course("Ruby-Language"));
		student.addCourse(new Course("Machine-Learning"));
		System.out.println("Save Student: "+student);
		System.out.println("Save Course associated by Student: "+student.getCourseList());
		studentCourseDAO.updateStudent(student);
		System.out.println("Updated!!");
	}

	private void deleteStudent(StudentCourseDAO studentCourseDAO)
	{
		System.out.println("-".repeat(30));
		System.out.println("Deleting only Student Details");
		System.out.println("-".repeat(30));
		int id = 3;
		System.out.println("Delete Student Id: "+id);
		studentCourseDAO.deleteStudentById(id);
		System.out.println("Completed...");
	}
	private void deleteCourse(StudentCourseDAO studentCourseDAO)
	{
		System.out.println("-".repeat(30));
		System.out.println("Deleting only Course Details");
		System.out.println("-".repeat(30));
		int id = 13;
		System.out.println("Delete Course Id: "+id);
		studentCourseDAO.deleteCourseById(id);
		System.out.println("Completed...");
	}
}
