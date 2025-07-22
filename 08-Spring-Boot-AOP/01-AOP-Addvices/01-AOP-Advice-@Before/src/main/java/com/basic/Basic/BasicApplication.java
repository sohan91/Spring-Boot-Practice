package com.basic.Basic;

import com.basic.Basic.dao.AccountDAO;
import com.basic.Basic.dao.ManagementDAO;
import org.springframework.beans.factory.annotation.Qualifier;
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
		dao.addAccount();
	    managementDAO.addAccount();
	}

}
