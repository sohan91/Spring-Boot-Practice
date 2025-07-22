package com.basic.Basic;

import com.basic.Basic.dao.AccountDAO;
import com.basic.Basic.dao.ManagementDAO;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.beans.BeanProperty;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

@SpringBootApplication
public class BasicApplication {

	public static void main(String[] args) {
		SpringApplication.run(BasicApplication.class, args);
	}
	@Bean
    public CommandLineRunner commandLineRunner( AccountDAO dao,
											   ManagementDAO managementDAO)
	{
		return runner->
		{
			add(dao,managementDAO);
		};
	}
	public void add(@Qualifier("accountImplementation") AccountDAO dao,
					@Qualifier("managementImplementation") ManagementDAO managementDAO)
	{

			Scanner scanner = new Scanner(System.in);
			System.out.println("Enter a Name: ");
			String name = scanner.nextLine();
			System.out.println("Enter age: ");
			int num = scanner.nextInt();
			dao.setAge(num);
			dao.setName(name);
		try {
			System.out.println("Age: " + dao.getAge());
		} catch (RuntimeException e) {
			System.out.println("Error with getting age: " + e.getMessage());
		}

		String[] arr = {"Sohan", "Manu", "ggb"};
			dao.accountHolders(Arrays.stream(arr).toList());
			System.out.println("List: " + dao.returnHolders());

	}

}
