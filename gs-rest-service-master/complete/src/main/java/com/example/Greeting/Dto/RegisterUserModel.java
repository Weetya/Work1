package com.example.Greeting.Dto;

public class RegisterUserModel {

	private String Username;
	private String Password;
	
	RegisterUserModel(String userName, String password) {
		this.setUsername(userName);
		this.setPassword(password);
	}

	public String getPassword() {
		return Password;
	}

	public void setPassword(String password) {
		this.Password = password;
	}

	public String getUsername() {
		return Username;
	}

	public void setUsername(String username) {
		this.Username = username;
	}
}
