package com.crude.RestCRUD.dao;

import com.crude.RestCRUD.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeJpaRepository extends JpaRepository<Employee,Integer> {

}
