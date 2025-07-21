package com.basic.Basic;

import com.basic.Basic.dao.AccountDAO;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.beans.BeanProperty;

@SpringBootApplication
public class BasicApplication {

	public static void main(String[] args) {
		SpringApplication.run(BasicApplication.class, args);
	}
	@Bean
    public CommandLineRunner commandLineRunner(AccountDAO dao)
	{
		return runner->
		{
			add(dao);
		};
	}
	public void add(AccountDAO accountDAO)
	{
		accountDAO.addAccount();
		System.out.println("-".repeat(30)+"\nOne More Check\n"+"-".repeat(30));
        accountDAO.addAccount();
	}

}
