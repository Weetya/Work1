package com.example.repose;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Greeting.Dto.RegisterUserModel;
@Repository 
public interface UserRepo extends JpaRepository<RegisterUserModel, Long> {
	RegisterUserModel findByUsername(String username);
}

