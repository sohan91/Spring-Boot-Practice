package com.example.security.SecurityFlow.repository;

import com.example.security.SecurityFlow.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo  extends JpaRepository<Users,Integer> {
   Users findByUserName(String user);
}
