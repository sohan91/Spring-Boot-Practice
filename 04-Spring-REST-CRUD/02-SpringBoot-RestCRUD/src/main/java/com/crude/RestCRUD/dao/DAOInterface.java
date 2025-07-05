package com.crude.RestCRUD.dao;

import com.crude.RestCRUD.entity.Employee;
import jakarta.el.ELManager;

import java.util.List;

public interface DAOInterface {
  List<Employee> findAll();
  Employee save(Employee employee);
  Employee findById(int id);
  void deleteById(int id);
}
