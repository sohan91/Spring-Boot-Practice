package com.crude.RestCRUD.dao;

import com.crude.RestCRUD.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.webmvc.RepositoryRestController;

@RepositoryRestResource (path = "members")
public interface EmployeeJpaRepository extends JpaRepository<Employee,Integer> {

}
