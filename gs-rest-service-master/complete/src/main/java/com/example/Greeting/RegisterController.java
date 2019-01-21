package com.example.Greeting;


import java.util.Collections;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import com.example.Greeting.Dto.RegisterUserModel;
import com.example.repose.UserRepo;

@Controller
public class RegisterController  {
	@Autowired
    private UserRepo userRepo;
	@Autowired
	private PasswordEncoder passwordEncoder;
	@GetMapping("/register")
	public String registerGet() {
		return "regist";
	}
	@PostMapping("/register")
	 public String addUser(RegisterUserModel user, Map<String, Object> model) {
        RegisterUserModel userFromDb = userRepo.findByUsername(user.getUsername());

        if (userFromDb != null) {
            model.put("message", "User exists!");
            return "registration";
        }

       user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepo.save(user);

        return "redirect:/login";
	} 
	
	

}
